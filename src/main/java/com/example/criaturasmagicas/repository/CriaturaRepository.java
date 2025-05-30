// Define o pacote onde a interface CriaturaRepository está localizada.
package com.example.criaturasmagicas.repository;

// Importa a interface JpaRepository do Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;
// Importa a classe Criatura que será gerenciada por este repositório.
import com.example.criaturasmagicas.model.Criatura;

/**
 * Interface de repositório para a entidade Criatura.
 * Estende JpaRepository para fornecer operações CRUD (Create, Read, Update, Delete)
 * e outras funcionalidades de persistência para a entidade Criatura.
 *
 * Os parâmetros de tipo são:
 * - Criatura: A classe da entidade que este repositório irá gerenciar.
 * - Long: O tipo da chave primária da entidade Criatura.
 */
public interface CriaturaRepository extends JpaRepository<Criatura, Long> {
    // Nenhuma implementação é necessária aqui, pois JpaRepository já fornece
    // todos os métodos básicos de persistência.
}