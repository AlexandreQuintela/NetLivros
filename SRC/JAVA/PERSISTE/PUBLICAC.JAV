/*
 * ClienteDAO.java
 *
 * Created on 1 de Novembro de 2008, 10:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;
import modelo.Categoria;
import modelo.Editora;
import modelo.Livro;
import modelo.Publicacao;
import pojo.PublicacaoPOJO;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class PublicacaoDAO {

    private Connection conn;
    String sql = "SELECT publicacao.categoriaId, publicacao.publicacao_id, livros.titulo, autores.nome, editora.editora_nome, categoria.categoria, publicacao.preco, livros.descricao, livros.edicao_num, livros.ano_publicacao FROM livrariavirtual.livros INNER JOIN livrariavirtual.publicacao ON (livros.isbn = publicacao.isbn) INNER JOIN livrariavirtual.autores ON (autores.autor_id = publicacao.autor_id) INNER JOIN livrariavirtual.editora ON (editora.editora_id = publicacao.editora_id) INNER JOIN livrariavirtual.categoria ON (categoria.categiriaId = publicacao.categoriaId)";

    public PublicacaoDAO() throws Exception {
        try {
            this.conn = Conexao2.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: " + ":\n" + e.getMessage());
        }
    }
//preparar para fazer apenas um método de pesquisa

    public List listaPrincipal() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql + " limit 0, 8");
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                int idPublicacao = rs.getInt(2);
                String titulo = rs.getString(3);
                String autor = rs.getString(4);
                String nomeEditora = rs.getString(5);
                String categoria = rs.getString(6);
                double preco = rs.getDouble(7);
                String descricao = rs.getString(8);
                int edicao = rs.getInt(9);
                String ano = rs.getString(10);
                list.add(new PublicacaoPOJO(idPublicacao, titulo, autor, nomeEditora, categoria, preco, descricao, edicao, ano));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //   Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaCompletaPesquisa(String tipoBusca, String busca) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (tipoBusca.equals("titulo")) {
                ps = conn.prepareStatement(sql + " Where livros.titulo like ?");
            } else if (tipoBusca.equals("isbn")) {
                ps = conn.prepareStatement(sql + " Where publicacao.isbn like ?");
            } else if (tipoBusca.equals("autor")) {
                ps = conn.prepareStatement(sql + " Where autores.nome like ?");
            } else if (tipoBusca.equals("editora")) {
                ps = conn.prepareStatement(sql + " Where editora.editora_nome like ?");
            }
            ps.setString(1, busca);
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                int idPublicacao = rs.getInt(2);
                String titulo = rs.getString(3);
                String autor = rs.getString(4);
                String nomeEditora = rs.getString(5);
                String categoria = rs.getString(6);
                double preco = rs.getDouble(7);
                String descricao = rs.getString(8);
                int edicao = rs.getInt(9);
                String ano = rs.getString(10);
                list.add(new PublicacaoPOJO(idPublicacao, titulo, autor, nomeEditora, categoria, preco, descricao, edicao, ano));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //   Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaCompletaCategoria(int idCategoria) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql + " Where publicacao.categoriaId like ? ");
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                int idPublicacao = rs.getInt(2);
                String titulo = rs.getString(3);
                String autor = rs.getString(4);
                String nomeEditora = rs.getString(5);
                String categoria = rs.getString(6);
                double preco = rs.getDouble(7);
                String descricao = rs.getString(8);
                int edicao = rs.getInt(9);
                String ano = rs.getString(10);
                list.add(new PublicacaoPOJO(idPublicacao, titulo, autor, nomeEditora, categoria, preco, descricao, edicao, ano));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //   Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaCompleta() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //ps = conn.prepareStatement("SELECT publicacao.publicacao_id, livros.titulo, autores.nome, editora.editora_nome FROM livraria.autores INNER JOIN livraria.publicacao ON (autores.autor_id = publicacao.autor_id) INNER JOIN livraria.editora ON (publicacao.editora_id = editora.editora_id) INNER JOIN livraria.livros ON (publicacao.isbn = livros.isbn)");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                int idPublicacao = rs.getInt(2);
                String titulo = rs.getString(3);
                String autor = rs.getString(4);
                String nomeEditora = rs.getString(5);
                String categoria = rs.getString(6);
                double preco = rs.getDouble(7);
                String descricao = rs.getString(8);
                int edicao = rs.getInt(9);
                String ano = rs.getString(10);
                list.add(new PublicacaoPOJO(idPublicacao, titulo, autor, nomeEditora, categoria, preco, descricao, edicao, ano));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //   Conexao2.fechar(conn, ps, rs);
        }
    }

    public void incluir(Publicacao publicacao) throws Exception {
        PreparedStatement ps = null;
        if (publicacao == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO publicacao (isbn, autor_id, editora_id, categoriaId, preco) values(?,?,?,?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, publicacao.getIsbn());
            ps.setInt(2, publicacao.getIdAutor());
            ps.setInt(3, publicacao.getIdEditora());
            ps.setInt(4, publicacao.getIdCategoria());
            ps.setDouble(5, publicacao.getPreco());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void atualizar(Publicacao publicacao) throws Exception {
        PreparedStatement ps = null;
        if (publicacao == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "update publicacao set publicacao_id=?, isbn=?, autor_id=?, editora_id=?, categoriaId=?, preco=? where publicacao_id = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, publicacao.getIdPublicacao());
            ps.setString(2, publicacao.getIsbn());
            ps.setInt(3, publicacao.getIdAutor());
            ps.setInt(4, publicacao.getIdEditora());
            ps.setInt(5, publicacao.getIdPublicacao());
            ps.setInt(6, publicacao.getIdCategoria());
            ps.setDouble(7, publicacao.getPreco());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }

            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void excluir(Publicacao publicacao) throws Exception {
        PreparedStatement ps = null;
        if (publicacao == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "delete from publicacao where publicacao_id=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, publicacao.getIdPublicacao());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }
    //quero uma lista como retorno public list

    public List todasPublicacoes() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from publicacao");
            rs = ps.executeQuery();
            List<Publicacao> list = new ArrayList<Publicacao>();
            while (rs.next()) {
                int idPublicacao = rs.getInt(1);
                String isbn = rs.getString(2);
                int autor = rs.getInt(3);
                int editora = rs.getInt(4);
                int categoria = rs.getInt(5);
                double preco = rs.getDouble(6);
                list.add(new Publicacao(idPublicacao, isbn, autor, editora, categoria, preco));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
    //quero de retorno uma Publicacao por isso uso o public objeto Publicacao

    public Publicacao procurarPublicacao(Integer idPublicacao) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from publicacao where publicacao_id=?");
            ps.setInt(1, idPublicacao);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o ID: " + idPublicacao);
            }
            String isbn = rs.getString(2);
            int autor = rs.getInt(3);
            int editora = rs.getInt(4);
            int categoria = rs.getInt(5);
            double preco = rs.getDouble(6);
            return new Publicacao(idPublicacao, isbn, autor, editora, categoria, preco);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //  Conexao2.fechar(conn, ps, rs);
        }
    }

    public PublicacaoPOJO procurarPublicacaoPOJO(Integer idPublicacao) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT publicacao.publicacao_id, livros.titulo, autores.nome, editora.editora_nome, categoria.categoria, publicacao.preco, livros.descricao, livros.edicao_num, livros.ano_publicacao FROM livrariavirtual.livros INNER JOIN livrariavirtual.publicacao ON (livros.isbn = publicacao.isbn) INNER JOIN livrariavirtual.autores ON (autores.autor_id = publicacao.autor_id) INNER JOIN livrariavirtual.editora ON (editora.editora_id = publicacao.editora_id) INNER JOIN livrariavirtual.categoria ON (categoria.categiriaId = publicacao.categoriaId) where publicacao_id=?");
            ps.setInt(1, idPublicacao);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o ID: " + idPublicacao);
            }
                String titulo = rs.getString(2);
                String autor = rs.getString(3);
                String nomeEditora = rs.getString(4);
                String categoria = rs.getString(5);
                double preco = rs.getDouble(6);
                String descricao = rs.getString(7);
                int edicao = rs.getInt(8);
                String ano = rs.getString(9);
            return new PublicacaoPOJO(idPublicacao, titulo, autor, nomeEditora, categoria, preco, descricao, edicao, ano);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //  Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaAutor() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from autores order by nome asc");
            rs = ps.executeQuery();
            List<Autor> list = new ArrayList<Autor>();
            while (rs.next()) {
                int idAutor = rs.getInt(1);
                String nome = rs.getString(2);
                list.add(new Autor(idAutor, nome));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
//            Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaEditora() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from editora order by editora_nome asc");
            rs = ps.executeQuery();
            List<Editora> list = new ArrayList<Editora>();
            while (rs.next()) {
                int idEditora = rs.getInt(1);
                String nomeEditora = rs.getString(2);
                list.add(new Editora(idEditora, nomeEditora));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
//            Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listarLivro() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from livros order by titulo asc");
            rs = ps.executeQuery();
            List<Livro> list = new ArrayList<Livro>();
            while (rs.next()) {
                String isbn = rs.getString(1);
                String titulo = rs.getString(2);
                list.add(new Livro(isbn, titulo));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //  Conexao2.fechar(conn, ps, rs);
        }
    }

    public List listaCategoria() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from categoria order by categoria asc");
            rs = ps.executeQuery();
            List<Categoria> list = new ArrayList<Categoria>();
            while (rs.next()) {
                int idCategoria = rs.getInt(1);
                String categoria = rs.getString(2);
                list.add(new Categoria(idCategoria, categoria));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //  Conexao2.fechar(conn, ps, rs);
        }
    }
}