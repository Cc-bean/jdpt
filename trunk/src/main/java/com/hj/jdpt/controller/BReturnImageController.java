//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
public class BReturnImageController {
    public BReturnImageController() {
    }

    @RequestMapping(
            value = {"/cunImg"},
            produces = {"image/jpeg"}
    )
    public BufferedImage getImage() throws IOException {
        InputStream is = new FileInputStream("D:/test.jpg");
        Throwable var2 = null;

        BufferedImage var3;
        try {
            var3 = ImageIO.read(is);
        } catch (Throwable var12) {
            var2 = var12;
            throw var12;
        } finally {
            if (is != null) {
                if (var2 != null) {
                    try {
                        is.close();
                    } catch (Throwable var11) {
                        var2.addSuppressed(var11);
                    }
                } else {
                    is.close();
                }
            }

        }

        return var3;
    }
}
