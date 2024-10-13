package Proyecto.Api.Rest.Repositories;

import Proyecto.Api.Rest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {



}
