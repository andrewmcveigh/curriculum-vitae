all: pdf md docx

pdf:
    pandoc andrew_mcveigh-cv.org -o andrew_mcveigh-cv.pdf --include-in-header=tex-header.tex

md:
    pandoc -f org -t gfm --wrap=none andrew_mcveigh-cv.org -o README.md

docx:
    pandoc -f org -t docx andrew_mcveigh-cv.org -o andrew_mcveigh-cv.docx --reference-doc=reference.docx
