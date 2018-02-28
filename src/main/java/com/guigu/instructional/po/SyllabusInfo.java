package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SyllabusInfo {
    private Integer syllabusId;

    @NotEmpty(message="{syllabusInfo.syllabusYi.isnull}")
    private String syllabusYi;

    @NotEmpty(message="{syllabusInfo.syllabusEr.isnull}")
    private String syllabusEr;

    @NotEmpty(message="{syllabusInfo.syllabusSan.isnull}")
    private String syllabusSan;

    @NotEmpty(message="{syllabusInfo.syllabusSi.isnull}")
    private String syllabusSi;

    @NotEmpty(message="{syllabusInfo.syllabusWu.isnull}")
    private String syllabusWu;

    @NotEmpty(message="{syllabusInfo.syllabusLiu.isnull}")
    private String syllabusLiu;

    @NotEmpty(message="{syllabusInfo.syllabusQi.isnull}")
    private String syllabusQi;

    private String syllabusIsused;

    @Size(min=2,max=10,message="{syllabusInfo.syllabusName.length.error}")
    @NotEmpty(message="{syllabusInfo.syllabusName.isnull}")
    private String syllabusName;

    public Integer getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    public String getSyllabusYi() {
        return syllabusYi;
    }

    public void setSyllabusYi(String syllabusYi) {
        this.syllabusYi = syllabusYi == null ? null : syllabusYi.trim();
    }

    public String getSyllabusEr() {
        return syllabusEr;
    }

    public void setSyllabusEr(String syllabusEr) {
        this.syllabusEr = syllabusEr == null ? null : syllabusEr.trim();
    }

    public String getSyllabusSan() {
        return syllabusSan;
    }

    public void setSyllabusSan(String syllabusSan) {
        this.syllabusSan = syllabusSan == null ? null : syllabusSan.trim();
    }

    public String getSyllabusSi() {
        return syllabusSi;
    }

    public void setSyllabusSi(String syllabusSi) {
        this.syllabusSi = syllabusSi == null ? null : syllabusSi.trim();
    }

    public String getSyllabusWu() {
        return syllabusWu;
    }

    public void setSyllabusWu(String syllabusWu) {
        this.syllabusWu = syllabusWu == null ? null : syllabusWu.trim();
    }

    public String getSyllabusLiu() {
        return syllabusLiu;
    }

    public void setSyllabusLiu(String syllabusLiu) {
        this.syllabusLiu = syllabusLiu == null ? null : syllabusLiu.trim();
    }

    public String getSyllabusQi() {
        return syllabusQi;
    }

    public void setSyllabusQi(String syllabusQi) {
        this.syllabusQi = syllabusQi == null ? null : syllabusQi.trim();
    }

    public String getSyllabusIsused() {
        return syllabusIsused;
    }

    public void setSyllabusIsused(String syllabusIsused) {
        this.syllabusIsused = syllabusIsused == null ? null : syllabusIsused.trim();
    }

    public String getSyllabusName() {
        return syllabusName;
    }

    public void setSyllabusName(String syllabusName) {
        this.syllabusName = syllabusName == null ? null : syllabusName.trim();
    }
}