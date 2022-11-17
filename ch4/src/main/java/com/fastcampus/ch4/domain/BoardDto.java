package com.fastcampus.ch4.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private Integer bno;
    private String tittle;
    private String content;
    private String writer;
    private int view_cnt;
    private int comment_cnt00; // 댓글 갯수
    private Date reg_date;

    public BoardDto() {}
    public BoardDto(String tittle, String content, String writer) {
        this.tittle = tittle;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(bno, boardDto.bno) && Objects.equals(tittle, boardDto.tittle) && Objects.equals(content, boardDto.content) && Objects.equals(writer, boardDto.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, tittle, content, writer);
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", view_cnt=" + view_cnt +
                ", comment_cnt00=" + comment_cnt00 +
                ", reg_date=" + reg_date +
                '}';
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getComment_cnt00() {
        return comment_cnt00;
    }

    public void setComment_cnt00(int comment_cnt00) {
        this.comment_cnt00 = comment_cnt00;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}
