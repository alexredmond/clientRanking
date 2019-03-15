package com.iva.clientranking.app.input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.iva.clientranking.app.object.dto.ClientRankingProperites;
import com.iva.clientranking.app.object.dto.InputDto;
import com.iva.clientranking.app.object.exception.ClientRankingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InputValidator {

    @Autowired
    private ClientRankingProperites clientRankingProperites;

    public void validateProperties() throws ClientRankingException {
        if (clientRankingProperites.getRankingLimit() == null ||
                clientRankingProperites.getRankingLimit().compareTo(0) <= 0) {
            throw new ClientRankingException("RanlingLimit must be higher than 0");
        }
        if (clientRankingProperites.getFilterStartDate() == null) {
            throw new ClientRankingException("RanlingStartDate must be a valid Date");
        }
    }

    public InputDto verifyFilesPresent(String... args) {
        if (args == null || args.length != 4) {
            return null;
        }
        InputDto inputDto = new InputDto();

        Path clientFilePath = Paths.get(args[0]);
        if (Files.exists(clientFilePath)) {
            inputDto.setClientFilePath(clientFilePath);
        } else {
            log.error("Client file not present: {}", args[0]);
        }
        Path appointmentFilePath = Paths.get(args[1]);
        if (Files.exists(appointmentFilePath)) {
            inputDto.setAppointmentFilePath(appointmentFilePath);
        } else {
            log.error("Appointment file not present: {}", args[1]);
        }
        Path serviceFilePath = Paths.get(args[2]);
        if (Files.exists(serviceFilePath)) {
            inputDto.setServiceFilePath(serviceFilePath);
        } else {
            log.error("Servcice file not present: {}", args[2]);
        }
        Path purchaseFilePath = Paths.get(args[3]);
        if (Files.exists(purchaseFilePath)) {
            inputDto.setPurchaseFilePath(purchaseFilePath);
        } else {
            log.error("Purchase file not present: {}", args[3]);
        }
        if (inputDto.getClientFilePath() == null || inputDto.getAppointmentFilePath() == null ||
                inputDto.getServiceFilePath() == null || inputDto.getPurchaseFilePath() == null) {
            return null;
        }
        return inputDto;
    }
}
