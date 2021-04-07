pdf-report:
	cd report && latexmk -pdf -synctex=1 -interaction=nonstopmode report.tex && mv report.pdf ../
dev-report:
	cd report && latexmk -pvc -pdf -synctex=1 -interaction=nonstopmode report && mv report.pdf ../

clean-report:
	cd report && rm *.aux *.bbl *.blg *.fdb_latexmk *.fls *.lof *.log *.lot *.out *.toc

diagram:
	./tools/compileMetaUML.sh report/diagrams/

diagram-pdf:
	./tools/compileMetaUMLpdf.sh report/diagrams/

open-pdf:
	zathura report/report.pdf &


all: diagram pdf-report
