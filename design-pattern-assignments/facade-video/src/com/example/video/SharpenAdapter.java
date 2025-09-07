package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        String framesHandle = convertFramesToHandle(frames);
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        return convertHandleToFrames(resultHandle, frames);
    }
    
    private String convertFramesToHandle(Frame[] frames) {
        return "FRAMES_" + frames.length;
    }
    
    private Frame[] convertHandleToFrames(String handle, Frame[] originalFrames) {
        return originalFrames;
    }
}
