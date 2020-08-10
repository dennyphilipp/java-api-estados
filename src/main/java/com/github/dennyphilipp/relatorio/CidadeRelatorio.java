package com.github.dennyphilipp.relatorio;

import com.github.dennyphilipp.dto.CidadeDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class CidadeRelatorio {
    private static final Logger logger = LoggerFactory.getLogger(CidadeRelatorio.class);
    private final List<CidadeDTO> lista;
    public CidadeRelatorio(List<CidadeDTO> lista) {
        this.lista = lista;
    }

    public ByteArrayOutputStream Gerar() throws DocumentException {
        logger.info("Inicio gerando relatorio cidade");
        Document documento = new Document(PageSize.A4, 5, 5, 5, 5);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(documento, out);
        documento.open();
        inserirTitulo(documento);
        inserirCidades(documento);
        documento.close();
        return out;
    }

    private void inserirCidades(Document documento) throws DocumentException {
        logger.info("Inserir cidades relatoio cidade");

        PdfPTable tabela = new PdfPTable(5);
        PdfPCell coluna = new PdfPCell(new Phrase("UF"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(coluna);

        coluna = new PdfPCell(new Phrase("Região"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(coluna);

        coluna = new PdfPCell(new Phrase("Cidade"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(coluna);

        coluna = new PdfPCell(new Phrase("Mesorregião"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(coluna);

        coluna = new PdfPCell(new Phrase("Formatado"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.addCell(coluna);

        if (lista != null && lista.size() > 0) {
            lista.forEach(cidade -> {
                PdfPCell coluna2 = new PdfPCell(new Phrase(cidade.getSiglaEstado()));
                coluna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell(coluna2);

                coluna2 = new PdfPCell(new Phrase(cidade.getRegiaoNome()));
                coluna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell(coluna2);

                coluna2 = new PdfPCell(new Phrase(cidade.getNomeCidade()));
                coluna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell(coluna2);

                coluna2 = new PdfPCell(new Phrase(cidade.getNomeMesorregiao()));
                coluna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell(coluna2);

                coluna2 = new PdfPCell(new Phrase(cidade.getNomeFormatado()));
                coluna2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell(coluna2);
            });
        } else {
            coluna = new PdfPCell(new Phrase("Nenhuma cidade encontrada."));
            coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
            coluna.setColspan(5);
            tabela.addCell(coluna);
        }
        documento.add(tabela);
    }

    private void inserirTitulo(Document documento) throws DocumentException {
        logger.info("Inserir titulo relatoio cidade");

        PdfPTable tabela = new PdfPTable(1);
        PdfPCell coluna = new PdfPCell(new Phrase("RELATÓRIO DE CIDADES"));
        coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
        coluna.setBorder(0);
        tabela.addCell(coluna);
        tabela.setSpacingAfter(5);
        documento.add(tabela);
    }
}
