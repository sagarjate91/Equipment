package com.measuring.equipment.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.measuring.equipment.model.Equipment;
import com.measuring.equipment.repository.EquipmentRepository;
import com.measuring.equipment.utility.DateUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

    @Autowired
    private EquipmentRepository repository;

    public void exportReport(HttpServletResponse response) throws JRException, IOException {
        List<Equipment> employees = repository.findAll();
        File file = ResourceUtils.getFile("classpath:equipment-list.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Sagar Jate");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
       
        response.setContentType("application/x-download");
        response.addHeader("Content-disposition", "attachment; filename="+DateUtils.getDate()+".pdf");
        ServletOutputStream sos = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, sos);
        sos.close();
    }
}
