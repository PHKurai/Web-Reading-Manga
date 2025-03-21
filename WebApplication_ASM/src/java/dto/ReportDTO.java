/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin PC
 */
public class ReportDTO {
    private int reportId;
    private String reporterId;
    private String typeOfReport;
    private String targetId;
    private String detail;
    private String imageOfReport;

    public ReportDTO() {
    }

    public ReportDTO(int reportId, String reporterId, String typeOfReport, String targetId, String detail, String imageOfReport) {
        this.reportId = reportId;
        this.reporterId = reporterId;
        this.typeOfReport = typeOfReport;
        this.targetId = targetId;
        this.detail = detail;
        this.imageOfReport = imageOfReport;
    }

    @Override
    public String toString() {
        return "ReportDTO{" + "reportId=" + reportId + ", reporterId=" + reporterId + ", typeOfReport=" + typeOfReport + ", targetId=" + targetId + ", detail=" + detail + ", imageOfReport=" + imageOfReport + '}';
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReporterId() {
        return reporterId;
    }

    public void setReporterId(String reporterId) {
        this.reporterId = reporterId;
    }

    public String getTypeOfReport() {
        return typeOfReport;
    }

    public void setTypeOfReport(String typeOfReport) {
        this.typeOfReport = typeOfReport;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageOfReport() {
        return imageOfReport;
    }

    public void setImageOfReport(String imageOfReport) {
        this.imageOfReport = imageOfReport;
    }
    
}
