package com.example.report;
import java.util.*;
import java.nio.file.*;

public class ReportBundleFacade {

    private JsonWriter jw;
    private Zipper z;
    private AuditLog log;

    public ReportBundleFacade() {
        this.jw = new JsonWriter();
        this.z = new Zipper();
        this.log = new AuditLog();
    }

    Path export(Map<String, Object> data, Path outdir, String fileName){
        Objects.requireNonNull(data);
        Objects.requireNonNull(outdir);
        Objects.requireNonNull(fileName);

        Path json = this.jw.write(data, outdir, fileName);
        Path zipPath = outdir.resolve(fileName + ".zip");
        Path zip = this.z.zip(json, zipPath);
        this.log.log("Exported report: " + fileName);
        return zip;
    }
}
