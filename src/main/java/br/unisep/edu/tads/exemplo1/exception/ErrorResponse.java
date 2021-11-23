package br.unisep.edu.tads.exemplo1.exception;

import java.util.Date;

public class ErrorResponse {

	private Date timestamp;
	private String status;
	private String messagem;
	private String detalhes;

	public ErrorResponse(Date timestamp, String status, String messagem, String detalhes) {
		this.timestamp = timestamp;
		this.status = status;
		this.messagem = messagem;
		this.detalhes = detalhes;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
