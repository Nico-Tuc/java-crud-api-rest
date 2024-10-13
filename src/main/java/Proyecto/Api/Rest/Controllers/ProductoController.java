package Proyecto.Api.Rest.Controllers;

import Proyecto.Api.Rest.Entities.Producto;
import Proyecto.Api.Rest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorID(@PathVariable long id){
     return productoRepository.findById(id)
     .orElseThrow(() -> new RuntimeException("No se encontro un producto con esa id: "+ id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detallesdeProducto){
        Producto producto =  productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro un producto con esa id: "+ id));

        producto.setNombre(detallesdeProducto.getNombre());
        producto.setPrecio(detallesdeProducto.getPrecio());

        return  productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable long id){
        Producto producto =  productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro un producto con esa id: "+ id));

        productoRepository.delete(producto);
        return "El producto con el ID: " + id + "fue eliminado";
    }
}
