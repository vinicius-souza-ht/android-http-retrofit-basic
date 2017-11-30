package fabricadeprogramador.com.br.retrofitbasic.model;

import java.io.Serializable;

/**
 * Created by viniciuspodi on 30/11/17.
 */

public class Pessoa implements Serializable{

    private Integer id;
    private String nome;

    //Construtores
    public Pessoa(){}

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    //Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //toString

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    //Hashcode e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) return false;
        return nome != null ? nome.equals(pessoa.nome) : pessoa.nome == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
