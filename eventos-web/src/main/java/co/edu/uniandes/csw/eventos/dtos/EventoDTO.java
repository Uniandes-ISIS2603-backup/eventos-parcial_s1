/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.eventos.dtos;

import co.edu.uniandes.csw.eventos.entities.EventoEntity;


public class EventoDTO {

    private Long id;
    private String name;
    private String tipo;

    /**
     * Constructor por defecto
     */
    public EventoDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param evento: Es la entidad que se va a convertir a DTO
     */
    public EventoDTO(EventoEntity evento) {
        this.id = evento.getId();
        this.name = evento.getName();
        this.tipo = evento.getTipo();

    }

    /**
     * @return El ID de la evento
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre de la evento
     */
    public String getName() {
        return name;
    }

    /**
     * @param name El nuevo nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return El tipo de la evento
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo El nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public EventoEntity toEntity() {
        EventoEntity entity = new EventoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setTipo(this.tipo);
        return entity;
    }
}
