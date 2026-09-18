package Api.company.relationships.controller;


import Api.company.relationships.database.model.Cargo;
import Api.company.relationships.dto.cargo.CargoDto;
import Api.company.relationships.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv2/cargo")
public class CargoController {

    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<Cargo> saveCargo(CargoDto dto){
        var cargo = cargoService.saveCargo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargo(){
        var cargo = cargoService.findAllCargo();
        return ResponseEntity.status(HttpStatus.OK).body(cargo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Long id){
        var cargo = cargoService.findCargoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> UpdateCargo(@PathVariable Long id, @RequestBody CargoDto dto){
        var cargo = cargoService.updateCargo(id, dto);
        return  ResponseEntity.status(HttpStatus.OK).body(cargo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCargo(@PathVariable Long id){
         cargoService.deleteCargo(id);
         return ResponseEntity.status(HttpStatus.OK).body("Sucessfully deleted");
    }


}
