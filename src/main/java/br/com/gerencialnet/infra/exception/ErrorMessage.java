package br.com.gerencialnet.infra.exception;

public class ErrorMessage {
	
	private String mensagem;
	
	public ErrorMessage() {	}
		public ErrorMessage(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMesnsagem(String mensagem) {
		this.mensagem = mensagem;
	}	

}
