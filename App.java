import java.util.HashMap;
import java.util.Scanner;

import controllers.CaixaController;
import controllers.CategoriaController;
import controllers.MercadoController;
import controllers.ProdutoController;
import models.Caixa;
import models.Carrinho;
import models.Categoria;
import models.Produto;
import repositorios.repositoriosImpl.CategoriaRepositorioImpl;
import repositorios.repositoriosImpl.ProdutoRepositorioImpl;
import seeds.CategoriaSeed;
import seeds.ProdutoSeed;
import textos.Menu;

public class App {
    private Menu menu = new Menu();

    private Scanner inp = new Scanner(System.in);

    private HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();

    private HashMap<Integer, Categoria> categorias = new HashMap<Integer, Categoria>();

    private Caixa caixa = new Caixa();

    private Carrinho carrinho = new Carrinho();

    private ProdutoRepositorioImpl produtoRepositorioImpl = new ProdutoRepositorioImpl(produtos);
    private CategoriaRepositorioImpl categoriaRepositorioImpl = new CategoriaRepositorioImpl(categorias);
    
    private CategoriaController categoriaController = new CategoriaController(categoriaRepositorioImpl, produtoRepositorioImpl);

    private ProdutoController produtoController = new ProdutoController(produtoRepositorioImpl, categoriaRepositorioImpl);
    
    private MercadoController mercadoController = new MercadoController(produtos, carrinho);

    private CaixaController caixaController = new CaixaController(caixa);

    public void iniciar() {
        ProdutoSeed.popular(produtos);
        CategoriaSeed.popular(categorias);

        int opcaoSelecionda = -1;
        do {
            try {
                menu.principal();
                opcaoSelecionda = inp.nextInt();
                selecionaOpcao(opcaoSelecionda);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (opcaoSelecionda != 0);

    }

    public void selecionaOpcao(int opcao) throws Exception {
        System.out.println("=======================================");
        do {
            switch (opcao) {
                case -1: {
                    break;
                }
                case 0: {

                    System.out.println("Saindo....");
                    break;
                }
                case 1: {
                    menu.produto();
                    opcao = inp.nextInt();
                    selecionaOpcaoProduto(opcao);
                    break;
                }
                case 2: {
                    menu.categoria();
                    opcao = inp.nextInt();
                    selecionaOpcaoCategoria(opcao);
                    break;
                }
                case 3: {
                    menu.caixa();
                    opcao = inp.nextInt();
                    selecionaOpcaoCaixa(opcao);
                    break;
                }

                case 4:
                    menu.mercado();
                    opcao = inp.nextInt();
                    selecionaOpcaoMercado(opcao);
                    break;
                default: 
                    System.out.println("Opcao invalida");
                break;
            }
            opcao = -1;
        } while (opcao != 0 && opcao != -1);

        System.out.println("=======================================");

    }

    public void selecionaOpcaoProduto(int opcao) throws Exception {
        switch (opcao) {
            case 0: break;
            case 1: {
                produtoController.verProduto();
                break;
            }
            case 2: {
                produtoController.adicionaProduto();
                break;
            }
            case 3: {
                produtoController.mostrarProdutos();
                break;
            }
            case 4: {
                produtoController.deletaProduto();
                break;
            }
            case 5: {
                produtoController.editaProduto();
                break;
            }
            default:
                System.out.println("Opcao nao existe");
                break;
        }
    }

    public void selecionaOpcaoCategoria(int opcao) throws Exception {
        switch (opcao) {
            case 0 : break;
            case 1: {
                categoriaController.verCategoria();
                break;
            }
            case 2: {
                categoriaController.adicionaCategoria();
                break;
            }
            case 3: {
                categoriaController.mostrarCategorias();
                break;
            }
            case 4: {
                categoriaController.deletaCategoria();
                break;
            }
            case 5: {
                categoriaController.editaCategoria();
                break;
            }
            default:
                System.out.println("Opcao nao existe");
                break;
        }
    }
    public void selecionaOpcaoCaixa(int opcao) throws Exception{
        switch (opcao) {
            case 0:                
                break;
            case 1: 
            caixaController.verFila();
                break;
            case 2: 
                caixaController.atenderCarrinho();
                break;
            default:
                break;
        }
    }

    public void selecionaOpcaoMercado(int opcao) throws Exception{
        switch (opcao) {
            case 0:

                break;
            case 1:
                mercadoController.verProdutos();
                break;
            case 2: 
                mercadoController.verCarrinho();
                break;
            case 3:
                mercadoController.adicionaProdutoCarrinho();
            break;
            case 4:
                mercadoController.removeProdutoCarrinho();
                break;
            case 5:
                caixaController.adicionaCarrinho(carrinho);
                break;
            default:
                break;
        }
    }
}