package jx3api.api.http.data.music;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author grafie
 * @since 2024/6/23  16:51
 */
@Data
public class MusicKugouData {

    @JsonProperty("SongName")
    public String songName;

    @JsonProperty("AlbumID")
    private String albumId;

    @JsonProperty("FileHash")
    private String fileHash;

    @JsonProperty("SQFileHash")
    private String sqFileHash;

    @JsonProperty("HQFileHash")
    private String hqFileHash;

    @JsonProperty("MvHash")
    private String mvHash;

    @JsonProperty("Audioid")
    private Long audioId;

    @JsonProperty("SingerName")
    private String singerName;

    @JsonProperty("PlayUrl")
    private String playUrl;

    @JsonProperty("Img")
    private String img;
}
