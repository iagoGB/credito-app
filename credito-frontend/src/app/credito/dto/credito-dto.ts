export interface CreditoDTO {
  numeroCredito: string;
  numeroNfse: string;
  dataConstituicao: Date; 
  valorIssqn: number;
  tipoCredito: string;
  simplesNacional: 'Sim' | 'Não';
  aliquota: number;
  valorFaturado: number;
  valorDeducao: number;
  baseCalculo: number;
}