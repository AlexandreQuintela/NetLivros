/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.util.Hashtable;
import java.util.Map;
import modelo.Carrinho;

/**
 *
 * @author Alexandre
 */
public class CarrinhoDAO {
/* Esse código tentei implementar mas não tenho conhecimentos para isso ainda.
        Map  carrinhoCompras = new Hashtable();
 * List <Autor> list = new ArrayList<Autor>();
        session.getAttribute("Car");
        if (carrinhoCompras == null) {
            carrinhoCompras = new Hashtable(10);
        }

        String cmd = request.getParameter("cmd");
        if (cmd != null && cmd.equals("adicionaItem")) {
            try {
                int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
                carrinho produto = dbBean.getProductDetails(idPublicacao);
                if (produto != null) {
                    Carrinho item = new Carrinho();
                    item.setIdPublicacao() = produto.idPublicacao;
                    item.setQuantidade() = 1;
                    item.setPreco() = produto.preco;
                    item.setTitulo() = produto.titulo;
                    item.setDescricao() = produto.descricao;

                    carrinhoCompras.remove(Integer.toString(idPublicacao));
                    carrinhoCompras.put(Integer.toString(idPublicacao), item);
                    session.setAttribute("carrinhoCompras", carrinhoCompras);
                }
            } catch (Exception e) {
                out.println("Erro ao adicionar produto ao carrinjo");
            }
        }

        if (cmd != null && cmd.equals("updateCarrinho")) {
            try {
                int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                Carrinho item = (Carrinho) carrinhoCompras.get(Integer.toString(idPublicacao));
                if (item != null) {
                    item.quantidade = quantidade;
                }
            } catch (Exception e) {
                out.println("Erro ao atualizar carrinho");
            }
        }

        if (cmd != null && cmd.equals("deleteCarrinho")) {
            try {
                int idPublicacao = Integer.parseInt(request.getParameter("idPublicacao"));
                carrinhoCompras.remove(Integer.toString(idPublicacao));
            } catch (Exception e) {
                out.println("Erro ao apagar item");
            }
        }*/
}
