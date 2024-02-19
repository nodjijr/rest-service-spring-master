package com.desafioapp.models;

import java.util.Date;

import lombok.Data;

@Data
public class ReturnStatus {

	private String codreturn;
	private Date timestamp;
	private String status;
	private String message;
	private String path;

	public ReturnStatus(String codreturn, String path) {
		super();
		Date date = new Date();
		this.setTimestamp(new Date(date.getTime()));
		this.codreturn = codreturn;
		this.path = path;

		switch (codreturn) {

		case "00200":
			this.message = "OK –  Obtenção com sucesso do(s) dado(s).";
			this.status = "200";
			break;
			
		case "00201":
			this.message = "OK –  Recurso excluído com êxito.";
			this.status = "200";
			break;			
			
		case "00204":
			this.message = "NO CONTENT –  O servidor cumpriu com sucesso o pedido.";
			this.status = "204";
			break;			
			
		case "00400":
			this.message = "Bad Request – A solicitação não pôde ser entendida pelo servidor devido à sintaxe malformada.";
			this.status = "400";
			break;
			
		case "00403":
			this.message = "Forbidden – O cliente não tem direitos de acesso ao conteúdo.";
			this.status = "403";
			break;							

		case "00404":
			this.message = "Not Found – O recurso não existe no caminho requisitado.";
			this.status = "404";
			break;
			
		case "00405":
			this.message = "Method Not Allowed – O método de solicitação é conhecido pelo servidor, mas foi desativado e não pode ser usado.";
			this.status = "405";
			break;
		}

	}

}
