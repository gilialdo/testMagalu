package br.com.magalutest.api.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import br.com.magalutest.api.model.Produto;
//import br.com.magalutest.api.repository.filter.ProdutoFilter;
//import br.com.magalutest.api.repository.querys.ProdutoRepositoryQuery;

//public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {
//
//    public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);

//    public Optional<Produto> findByIdProduto(Long idProduto);
//    public Optional<Produto> findByPrice(Double price);
//    public Optional<Produto> findByImage(String image);
//    public Optional<Produto> findByBrand(String brand);
//    public Optional<Produto> findById(String id);
//    public Optional<Produto> findByTitle(String title);
//    public Optional<Produto> findByReviewScore(String reviewScore);

//}
