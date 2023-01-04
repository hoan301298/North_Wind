package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Strings;
import fi.vamk.e2000575.northwind.service.StringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Strings")
public class StringsController {

    @Autowired
    private StringsService StringsService;

    @GetMapping
    public ResponseEntity<?> getStrings() {
        List<Strings> Strings = StringsService.getStrings();
        return ResponseEntity.ok(Strings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStringsById(@PathVariable int id) {
        Optional<Strings> Strings = StringsService.getStringsById(id);
        return ResponseEntity.ok(Strings);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchStrings(@RequestParam(name = "keyword") String stringData) {
        List<Strings> Strings = StringsService.searchStrings(stringData);
        return ResponseEntity.ok(Strings);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createStrings(@RequestBody Strings result) {
        Strings Strings = StringsService.createStrings(result);
        return ResponseEntity.ok(Strings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStrings(@PathVariable int id, @RequestBody Strings result) {
        Strings Strings = StringsService.updateStrings(id, result);
        return ResponseEntity.ok(Strings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStrings(@PathVariable("id") int id) {
        Strings Strings = StringsService.deleteStrings(id);
        return ResponseEntity.ok(Strings);
    }

}
