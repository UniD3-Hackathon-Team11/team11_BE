package com.team11.be.backoffice;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.team11.be.domain.stage.dto.StageRequestDto;
import com.team11.be.domain.stage.dto.StageResponseDto;
import com.team11.be.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BackOfficeController {

    private final StageService stageService;

    @GetMapping("/backoffice/stages")
    public String getStages(Model model){
        List<StageResponseDto> stages = stageService.getAllStages();

        model.addAttribute("stages", stages);
        return "stages/stagesListPage";
    }

    @GetMapping("/backoffice/stages/create")
    public String createStagePage(){
        return "stages/stagesCreatePage";
    }

    @PostMapping("/backoffice/stages")
    public String createStage(StageRequestDto stageRequestDto){
        stageService.postStage(stageRequestDto);

        return "redirect:/backoffice/stages";
    }

    @GetMapping("/backoffice/stages/{id}/delete")
    public String createStage(@PathVariable Long id){
        stageService.deleteStage(id);

        return "redirect:/backoffice/stages";
    }

    @GetMapping("/backoffice/stages/getQrcode/{id}")
    public String getQrcode(Model model, @PathVariable Long id) throws Exception {

        String img = getQRCodeImage(String.valueOf(id), 200, 200);
        model.addAttribute("img", img);

        return "stages/qrcode";
    }

    // QR코드 이미지 생성
    public static String getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        return Base64.getEncoder().encodeToString(pngOutputStream.toByteArray());
    }
}
