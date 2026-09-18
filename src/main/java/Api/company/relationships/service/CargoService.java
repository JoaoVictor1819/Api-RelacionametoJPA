package Api.company.relationships.service;

import Api.company.relationships.database.model.Cargo;
import Api.company.relationships.database.repository.CargoRespository;
import Api.company.relationships.dto.cargo.CargoRequestDto;
import Api.company.relationships.exception.ResourceExceptonHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private CargoRespository cargoRespository;

    public CargoService(CargoRespository cargoRespository) {
        this.cargoRespository = cargoRespository;
    }

    public Cargo saveCargo(CargoRequestDto dto){
        Cargo cargo = new Cargo(dto);
        return cargoRespository.save(cargo);
    }

    public List<Cargo> findAllCargo(){
        return cargoRespository.findAll();
    }

    public Cargo findCargoById(Long id){
        return cargoRespository.findById(id)
                .orElseThrow(() -> new ResourceExceptonHandler("with id"  + id + " not found"));
    }

    public void deleteCargo(Long id){
        if (!cargoRespository.existsById(id)|| cargoRespository.findById(id).isEmpty()){
            throw new ResourceExceptonHandler("with id"  + id + " not found");
        }

        cargoRespository.deleteById(id);
    }

    public Cargo updateCargo(Long id, CargoRequestDto dto){
        var cargo = cargoRespository.findById(id)
                .orElseThrow(() -> new ResourceExceptonHandler("with id"  + id + " not found"));

        cargo.setNomeCargo(dto.nomeCargo());
        cargo.setDescricaoCargo(dto.descricaoCargo());
        cargo.setSalarioCargo(dto.salarioCargo());
        return cargoRespository.save(cargo);
    }
}
