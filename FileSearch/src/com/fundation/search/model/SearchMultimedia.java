package com.fundation.search.model;

import com.fundation.search.controller.CriterialSearch;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class SearchMultimedia extends Search{
    private double duration;
    private double frameRate;
    private int height;
    private int width;
    private  String aspectRatio;
    private String codec;
    private FFprobe fFprobe;
    private static final String SEPARATOR = System.getProperty("file.separator");
    private List<Asset> pathListMultimedia = new ArrayList<>();

    @Override
    public List<Asset> searchCriterial(CriterialSearch criteria) throws IOException {
        File files = new File(criteria.getDirectory());
        File[] ficheros = files.listFiles();
        for (File fileIterate : ficheros) {
            if (fileIterate.isDirectory()) {
                criteria.setDirectory(fileIterate.getPath());
                searchCriterial(criteria);
            } else {
                try{
                    Path filePath = Paths.get(fileIterate.getPath());
                    attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                    String ffprobeBinaryPath = new File(".").getCanonicalFile() + SEPARATOR + "resources" + SEPARATOR + "ffprobe.exe";
                    String videoPath = fileIterate.getCanonicalPath();
                    fFprobe = new FFprobe(ffprobeBinaryPath);
                    FFmpegStream multimediaFile = fFprobe.probe(videoPath).getStreams().get(0);
                    UserPrincipal ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);

                    duration = Math.round(multimediaFile.duration);
                    frameRate = multimediaFile.r_frame_rate.doubleValue();
                    height = multimediaFile.height;
                    width = multimediaFile.width;
                    aspectRatio = multimediaFile.display_aspect_ratio;
                    codec = multimediaFile.codec_name;
                    System.out.println("duration: " + duration);
                    System.out.println("frame Rate: " + frameRate);
                    System.out.println("Dimension : " + width + "X" + height);
                    System.out.println("aspect Ratio: " + aspectRatio);
                    System.out.println("codec: " + codec);

                    if (fileIterate.isHidden() != criteria.isHidden()) {
                        continue;
                    }
                    if (criteria.getExtencionMultimedia() != null && !fileIterate.getName().toLowerCase().endsWith(criteria.getExtencionMultimedia())) {
                        continue;
                    }
                    if (!criteria.getInputSizeMultimedia().equals("0") &&
                            !durationMultimedia(criteria.getCountMultimedia(), criteria.getInputSizeMultimedia(),
                                    criteria.getDurationTypeMultimedia())) {
                        continue;
                    }
                    if (!criteria.getVideoCode().isEmpty() && !criteria.getVideoCode().equalsIgnoreCase(codec)) {
                        continue;
                    }
                    if (!criteria.getAudioCode().isEmpty() && !criteria.getAudioCode().equalsIgnoreCase(codec)) {
                        continue;
                    }
                    if (!criteria.getFrameRate().isEmpty() && !criteria.getFrameRate().equalsIgnoreCase(String.valueOf(frameRate))) {
                        continue;
                    }
                    if (!criteria.getResolution().isEmpty() && !resolution(criteria.getResolution())) {
                        continue;
                    }
                    System.out.println(fileIterate.canWrite());
                    /*pathListMultimedia.add(new AssetMultimedia(fileIterate.getAbsolutePath(), fileIterate.getName(),
                            fileIterate.length(), getFileExtension(fileIterate),
                            ownerFile.getName(), fileIterate.isHidden(), "",
                            fileIterate.canWrite(), criteria.isKeySensitive(),
                            false, false, criteria.isStarWord(),
                            criteria.isContentWord(), criteria.isEndWord(), "", duration, duration,
                            height, width, aspectRatio, codec));*/

                    pathListMultimedia.add(new AssetMultimedia(fileIterate.getAbsolutePath(),fileIterate.getName(),fileIterate.length(),
                            getFileExtension(fileIterate),ownerFile.getName(),fileIterate.isHidden(), fileIterate.canWrite(),
                            formatDateString(attr.creationTime().toMillis()),formatDateString(attr.lastModifiedTime().toMillis()),
                            formatDateString(attr.lastAccessTime().toMillis()), duration,duration,height,width, aspectRatio,codec));

                }catch(IOException e) {
                }
            }

        }
        return pathListMultimedia;
    }
    public boolean durationMultimedia (String countMultimedia, String inputSizeMultimedia, String durationTypeMultimedia) throws IOException {
        if (durationTypeMultimedia.equalsIgnoreCase("minutes")){
            if (countMultimedia.equals(" = ")){
                if(duration / 60 == Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" < ")){
                if(duration / 60 < Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" > ")){
                if (duration / 60 > Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
        }
        if (durationTypeMultimedia.equalsIgnoreCase("Hora")){
            double multimedia = duration / 60;
            if (countMultimedia.equals(" = ")){
                if(multimedia/60 == Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" < ")){
                if (multimedia/60 < Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" > ")){
                if (multimedia / 60 > Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
        }
        if (durationTypeMultimedia.equalsIgnoreCase("Seconds")){
            if (countMultimedia.equals(" = ")){
                if (duration == Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" < ")){
                if (duration < Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
            if (countMultimedia.equals(" > ")){
                if(duration > Double.parseDouble(inputSizeMultimedia)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean resolution(String resolutionVideo) throws IOException {
        String resolutionThisVideo = String.valueOf(width)+" x "+String.valueOf(height);
        if(resolutionVideo.equalsIgnoreCase(resolutionThisVideo)){
            return true;
        }
        return false;
    }
}
