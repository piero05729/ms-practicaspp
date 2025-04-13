package upeu.edu.pe.msppp.service.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.msppp.domain.Ppp;
import upeu.edu.pe.msppp.repository.PppRepository;
import upeu.edu.pe.msppp.service.IPppService;

import java.util.List;
import java.util.Optional;

@Service
public class IPppServiceImpl implements IPppService {

    @Autowired
    private PppRepository pppRepository;

    @Override
    public Ppp create(Ppp ppp) {
        return pppRepository.save(ppp);
    }

    @Override
    public Ppp update(Ppp ppp) {
        return pppRepository.save(ppp);
    }

    @Override
    public void delete(Long id) {
        pppRepository.deleteById(id);
    }

    @Override
    public Optional<Ppp> read(Long id) {
        return pppRepository.findById(id);
    }

    @Override
    public List<Ppp> readAll() {
        return pppRepository.findAll();
    }
=======
public class IPppServiceImpl {
>>>>>>> 0f47dfd13f5478dabb2ff879428148ce9b163243
}
