package com.pack.senderMail.Work.Import;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.pack.senderMail.Work.Import.Importcsv;
@RestController
public class CSVController {

    @PostMapping("/uploadCSV")
    public String uploadCSV(@RequestParam("file") MultipartFile file,@RequestParam("nomtable") String nomtable) {
         if (file.isEmpty()) {
        return "Veuillez sélectionner un fichier CSV.";
        }
        try {
            Importcsv importcsv = new Importcsv(nomtable);
            return importcsv.uploadCSV(file);
        } catch (Exception e) {
        System.out.println("CSVController ligne 24 :"+e);
        return "Erreur lors de l'import du fichier CSV : " + e.getMessage();
        }
    }
}
