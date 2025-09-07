package com.example.video;
import java.nio.file.Path;

public class VideoPipelineFacade {
    public static Path process(Path src, Path out, boolean gray, double scale, int sharpenStrength){
        Decoder dec = new Decoder();
        FilterEngine fe = new FilterEngine();
        Encoder enc = new Encoder();
        SharpenAdapter ls = new SharpenAdapter(new LegacySharpen());

        Frame[] frames = dec.decode(src);
        if (gray) frames = fe.grayscale(frames);
        frames = fe.scale(frames, scale);
        ls.sharpen(frames, sharpenStrength);
        return enc.encode(frames, out);
    }
}
