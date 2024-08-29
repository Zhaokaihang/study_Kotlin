package com.example.spsample.retrofit;

public class Bean {

    private Integer code;
    private ResultDTO result;
    private String msg;

    @Override
    public String toString() {
        return "Bean{" +
                "code=" + code +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static class ResultDTO {
        private String tts;
        private String content;
        private String note;
        private String dateline;
        private String img;

        @Override
        public String toString() {
            return "ResultDTO{" +
                    "tts='" + tts + '\'' +
                    ", content='" + content + '\'' +
                    ", note='" + note + '\'' +
                    ", dateline='" + dateline + '\'' +
                    ", img='" + img + '\'' +
                    '}';
        }
    }
}
