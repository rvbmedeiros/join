<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="http://xml.apache.org/xslt/java" exclude-result-prefixes="java" version="1.0">

	<xsl:output method="html" indent="yes" />
	<xsl:template match="/">
		<html>

			<head>
				<style type="text/css">
					table.tfmt {
					border: 1px ;
					width: 100%;
					}

					td.colfmt {
					border: 1px ;
					background-color: white;
					color: black;
					text-align:right;
					}

					th {
					background-color: #2E9AFE;
					color: white;
					}

					input[type=text], select {
					width: 100%;
					padding: 12px 20px;
					margin: 8px 0;
					display: inline-block;
					border: 1px solid #ccc;
					border-radius: 4px;
					box-sizing: border-box;
					}

					input[type=submit] {
					width: 100%;
					background-color: #4CAF50;
					color: white;
					padding: 14px 20px;
					margin: 8px 0;
					border: none;
					border-radius: 4px;
					cursor: pointer;
					}

					input[type=submit]:hover {
					background-color: #45a049;
					}

					div {
					border-radius: 5px;
					background-color: #f2f2f2;
					padding: 20px;
					}

				</style>
			</head>

			<body>

				<xsl:if test="errors/error != null">
					<div>
						<xsl:for-each select="errors/error">
							<span>
								<xsl:value-of select="code" />
							</span>
							<span>
								<xsl:value-of select="description" />
							</span>
						</xsl:for-each>
					</div>
				</xsl:if>

				<div>
					<form action="salvar" method="post">

						<label for="idt">ID:</label>
						<input type="text" id="idt" name="idt" disabled="true" value="{//page/id}" />

						<label for="type">Tipo:</label>
						<select id="type" name="type" placeholder="Selecione o tipo" value="{//page/type}">
							<option value="f">física</option>
							<option value="j">jurídica</option>
						</select>

						<label for="nome">Nome/Razão Social:</label>
						<input type="text" id="nome" name="nome" placeholder="Digite o nome ou razão social" value="{//page/name}" />

						<label for="municipio">Município:</label>
						<input type="text" id="municipio" name="municipio" placeholder="Digite o município" value="{//page/city}" />

						<label for="estado">UF:</label>
						<select id="estado" name="estado" placeholder="Selecione o estado" value="{//page/uf}">
							<option value="outros">Outros</option>
							<option value="pr">Paraná</option>
							<option value="rs">Rio Grande do Sul</option>
							<option value="df">Brasília</option>
						</select>

						<label for="nascimento">Data de Nascimento:</label>
						<input type="text" id="nascimento" name="nascimento" placeholder="Digite a data de nascimento" value="{//page/birthdate}" />

						<input type="submit" value="Submit" />
					</form>
				</div>

				<div>
					<table class="tfmt">
						<tr>
							<th style="width:250px">ID:</th>
							<th style="width:250px">Tipo:</th>
							<th style="width:250px">Nome/Razão Social:</th>
							<th style="width:250px">Data de Nascimento:</th>
							<th style="width:250px">UF:</th>
							<th style="width:350px">Município:</th>
							<th style="width:250px">Ação:</th>
						</tr>

						<xsl:for-each select="page/customer">

							<tr>
								<td class="colfmt">
									<xsl:variable name="hyperlink">
										<xsl:text>cadastro?id=<xsl:value-of select="id" /></xsl:text>
									</xsl:variable>
									<a href="{$hyperlink}">
										<xsl:value-of select="id" />
									</a>
								</td>
								<td class="colfmt">
									<xsl:value-of select="type" />
								</td>
								<td class="colfmt">
									<xsl:value-of select="name" />
								</td>
								<td class="colfmt">
									<xsl:value-of select="birthdate" />
								</td>
								<td class="colfmt">
									<xsl:value-of select="uf" />
								</td>
								<td class="colfmt">
									<xsl:value-of select="city" />
								</td>
								<td class="colfmt">
									<xsl:variable name="hyperlink">
										<xsl:text>deletar?id=<xsl:value-of select="id" /></xsl:text>
									</xsl:variable>
									<a href="{$hyperlink}">
										excluir
									</a>
								</td>
							</tr>

						</xsl:for-each>
					</table>
				</div>
				
				<div>
					<form action="exportar" method="post">
						<input type="submit" value="Exportar PDF" />
					</form>
				</div>
				
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>