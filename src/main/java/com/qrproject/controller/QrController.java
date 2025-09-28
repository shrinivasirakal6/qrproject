package com.qrproject.controller;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@RestController
public class QrController {

    @GetMapping("/save-qr")
    public String saveQr() throws IOException, WriterException {
        // The URL your QR should point to
        String qrContent = "http://localhost:8080/my-links";

        //this is an experimental lineq
        // this is for conflict

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, 300, 300);

        // Save file as PNG inside project folder
        Path path = FileSystems.getDefault().getPath("qr-code.png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return "✅ QR Code saved at: " + path.toAbsolutePath();
    }
}

