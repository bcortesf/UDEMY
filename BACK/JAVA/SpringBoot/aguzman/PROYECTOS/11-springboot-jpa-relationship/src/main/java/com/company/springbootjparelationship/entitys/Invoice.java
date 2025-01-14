package com.company.springbootjparelationship.entitys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double total;


    /* LLAVE_FORANEA: (nombramiento-pordefecto): En caso de no tener propiedad "@JoinColumn"
     *           - "fk" + <NOMBRE-ATRIBUTO> + <ID>   =   "client_id"
     **/
    //->ATRIBUTO-BI-DIRECCIONAL: dueña-de-la-relacion-por-ManyToOne
    @JoinColumn(name = "fk_client_id")  //->Definir-manualmente-nombre-llave-foranea
    @ManyToOne                          //->Relacion: ManyInvoice_To_OneClient
    private Client client;


    public Invoice() {
    }
    public Invoice(String description, Double total) {          //create
        this.description = description;
        this.total = total;
    }
    public Invoice(Long id, String description, Double total) { //update
        this.id = id;
        this.description = description;
        this.total = total;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    public Invoice getInvoice(){
        return this;
    }


    /*
     * EQUALS/HASHCODE
     * List: acepta duplicados, solo es suficiente con Invoice<id>                                          .. equals()
     * Set : NO acepta duplicados, poner todos los atributos sin relaciones Invoice<id, description, total> .. hashCode()
     */
    @Override
    public int hashCode() {
        //->HASCODE: SE APLICA A LOS "SET"
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        //->EQUALS: SE APLICA A LOS "LIST"
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Invoice other = (Invoice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "{id=" + id +
                ", description=" + description +
                ", total=" + total +
                // ", client=" + client +  /*->DEJAR uno de los dos en:  toString().client ó toString().invoice;  PARA-EVITAR-LOOP-INFINITO*/
                "}";
    }
}
