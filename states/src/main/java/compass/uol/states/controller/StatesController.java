package compass.uol.states.controller;


import compass.uol.states.controller.dto.StatesDto;
import compass.uol.states.controller.form.StatesForm;
import compass.uol.states.model.RegionEnum;
import compass.uol.states.model.States;
import compass.uol.states.repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StatesController {

    @Autowired
    private StatesRepository statesRepository;


    //Lista os estados com filtro por região
    @GetMapping
    public List<StatesDto> listByFilter(RegionEnum region){
        if (region == null) {
            List<States> states = statesRepository.findAll();
            return StatesDto.convert(states);
        } else {
            List<States> states = statesRepository.findByRegion(region);
            return StatesDto.convert(states);
        }
    }

    //método para cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity<StatesDto> register(@RequestBody @Valid StatesForm form, UriComponentsBuilder uriBuilder) {
        States state = form.getStates(form);
        statesRepository.save(state);

        URI uri = uriBuilder.path(("/api/states/{id}")).buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StatesDto(state));
    }

    //busca por um estado referenciado ao id
    @GetMapping("/{id}")
    public ResponseEntity<StatesDto> search(@PathVariable Long id) {
        Optional<States> state = statesRepository.findById(id);
        if (state.isPresent()) {
            return ResponseEntity.ok(new StatesDto(state.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //atualiza a lista de estados pelo id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StatesDto> update(@PathVariable Long id, @RequestBody @Valid StatesForm form ) {
        Optional<States> optional = statesRepository.findById(id);
        if (optional.isPresent()) {
            States state = form.update(id, statesRepository);
            return ResponseEntity.ok(new StatesDto(state));
        }
        return ResponseEntity.notFound().build();
    }

    //deleta estados por id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<States> optional = statesRepository.findById(id);
        if (optional.isPresent()) {
            statesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
