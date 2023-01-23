package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Strings;
import fi.vamk.e2000575.northwind.repository.StringsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StringsService {
    @Autowired
    private StringsRepository StringsRepository;

    public List<Strings> getStrings() {
        return StringsRepository.findAll();
    }
    public Optional<Strings> getStringsById(int id) {
        return StringsRepository.findById(id);
    }

    public List<Strings> searchStrings(String stringData){
        List<Strings> result = new ArrayList<>();
        for(Strings strings : getStrings()) {
            if(strings.getStringData().contains(stringData))
                result.add(strings);
        }
        return result;
    }
    public Strings createStrings(Strings result){
        return StringsRepository.save(result);
    }

    public Strings updateStrings(int id, @NotNull Strings result){
        if(result.getId() == id) {
            return StringsRepository.save(result);
        } else {
            return null;
        }
    }

    public Strings deleteStrings(int id) {
        Optional<Strings> result = StringsRepository.findById(id);

        if(result.isPresent())
            StringsRepository.deleteById(id);

        return null;
    }
}
