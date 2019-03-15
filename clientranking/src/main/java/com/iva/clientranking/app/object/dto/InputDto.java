package com.iva.clientranking.app.object.dto;

import java.nio.file.Path;

import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Data
public class InputDto {

    private Path clientFilePath;
    private Path appointmentFilePath;
    private Path serviceFilePath;
    private Path purchaseFilePath;

}
