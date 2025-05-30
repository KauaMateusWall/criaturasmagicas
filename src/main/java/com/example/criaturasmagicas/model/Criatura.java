// Define o pacote onde a classe Criatura está localizada.
package com.example.criaturasmagicas.model;

// Importa as anotações JPA necessárias para mapear a classe para uma tabela de banco de dados.
import jakarta.persistence.Entity; // Indica que esta classe é uma entidade JPA.
import jakarta.persistence.GeneratedValue; // Configura a estratégia de geração de valor para a chave primária.
import jakarta.persistence.GenerationType; // Define os tipos de estratégia de geração de valor.
import jakarta.persistence.Id; // Marca o campo como a chave primária da entidade.

/**
 * Classe que representa a entidade Criatura no banco de dados.
 * Cada instância desta classe corresponde a uma linha na tabela 'criatura'.
 */
@Entity // Anotação que diz ao Spring que essa classe representa uma tabela no banco de dados.
public class Criatura {

    // Define o atributo 'id' como a chave primária da tabela.
    @Id
    // Configura a geração automática do ID. IDENTITY usa a funcionalidade de auto-incremento do banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária da criatura.

    private String nome; // Nome da criatura.
    private String tipo; // Tipo da criatura (e.g., Dragão, Elfo).
    private int nivel; // Nível da criatura.

    // --- Getters e Setters ---
    // Métodos para acessar e modificar os atributos da criatura.

    /**
     * Retorna o ID da criatura.
     * @return O ID da criatura.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da criatura.
     * @param id O novo ID da criatura.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome da criatura.
     * @return O nome da criatura.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da criatura.
     * @param nome O novo nome da criatura.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o tipo da criatura.
     * @return O tipo da criatura.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da criatura.
     * @param tipo O novo tipo da criatura.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o nível da criatura.
     * @return O nível da criatura.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Define o nível da criatura.
     * @param nivel O novo nível da criatura.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}