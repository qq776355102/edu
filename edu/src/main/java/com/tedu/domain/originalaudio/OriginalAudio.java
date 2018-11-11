package com.tedu.domain.originalaudio;

import java.util.Date;

public class OriginalAudio {
    /**
     * 主键id
     */
    private Integer ginal;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 原音频文件原名
     */
    private String originalFileName;

    /**
     * 原音频音频长度
     */
    private String fileLength;

    /**
     * 原音频采样率
     */
    private String hz;

    /**
     * 原音频音量
     */
    private String volume;

    /**
     * 原音频通道数
     */
    private String channels;

    /**
     * 原音频比特率值
     */
    private String bitRate;

    /**
     * 上传日期
     */
    private Date date;

    /**
     * 数据状态
     */
    private Integer status;

    /**
     * 原音频存放位置
     */
    private String path;

    /**
     * 主键id
     * @return ginal 主键id
     */
    public Integer getGinal() {
        return ginal;
    }

    /**
     * 主键id
     * @param ginal 主键id
     */
    public void setGinal(Integer ginal) {
        this.ginal = ginal;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 原音频文件原名
     * @return original_file_name 原音频文件原名
     */
    public String getOriginalFileName() {
        return originalFileName;
    }

    /**
     * 原音频文件原名
     * @param originalFileName 原音频文件原名
     */
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName == null ? null : originalFileName.trim();
    }

    /**
     * 原音频音频长度
     * @return file_length 原音频音频长度
     */
    public String getFileLength() {
        return fileLength;
    }

    /**
     * 原音频音频长度
     * @param fileLength 原音频音频长度
     */
    public void setFileLength(String fileLength) {
        this.fileLength = fileLength == null ? null : fileLength.trim();
    }

    /**
     * 原音频采样率
     * @return hz 原音频采样率
     */
    public String getHz() {
        return hz;
    }

    /**
     * 原音频采样率
     * @param hz 原音频采样率
     */
    public void setHz(String hz) {
        this.hz = hz == null ? null : hz.trim();
    }

    /**
     * 原音频音量
     * @return volume 原音频音量
     */
    public String getVolume() {
        return volume;
    }

    /**
     * 原音频音量
     * @param volume 原音频音量
     */
    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    /**
     * 原音频通道数
     * @return channels 原音频通道数
     */
    public String getChannels() {
        return channels;
    }

    /**
     * 原音频通道数
     * @param channels 原音频通道数
     */
    public void setChannels(String channels) {
        this.channels = channels == null ? null : channels.trim();
    }

    /**
     * 原音频比特率值
     * @return bit_rate 原音频比特率值
     */
    public String getBitRate() {
        return bitRate;
    }

    /**
     * 原音频比特率值
     * @param bitRate 原音频比特率值
     */
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate == null ? null : bitRate.trim();
    }

    /**
     * 上传日期
     * @return date 上传日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 上传日期
     * @param date 上传日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 数据状态
     * @return status 数据状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 数据状态
     * @param status 数据状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 原音频存放位置
     * @return path 原音频存放位置
     */
    public String getPath() {
        return path;
    }

    /**
     * 原音频存放位置
     * @param path 原音频存放位置
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}