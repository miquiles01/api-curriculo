package com.example.curiculos.entidade.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaidaDto {

	
    private Long id;
	private String nome;
	private String telefone;
	private String educacao;
	private String experiencias;

}