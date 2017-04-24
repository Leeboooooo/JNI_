../Patch ../Diff:bzip2/blocksort.c bzip2/bzip2.c bzip2/bzip2recover.c bzip2/bzlib.c bzip2/compress.c  bzip2/crctable.c bzip2/decompress.c bzip2/huffman.c bzip2/randtable.c patch.c diff.c
	gcc bzip2/blocksort.c bzip2/bzip2.c bzip2/bzip2recover.c bzip2/bzlib.c bzip2/compress.c  bzip2/crctable.c bzip2/decompress.c bzip2/huffman.c bzip2/randtable.c patch.c -o ../Patch
	gcc bzip2/blocksort.c bzip2/bzip2.c bzip2/bzip2recover.c bzip2/bzlib.c bzip2/compress.c  bzip2/crctable.c bzip2/decompress.c bzip2/huffman.c bzip2/randtable.c diff.c -o ../Diff

.PHONY: edit clean
clean:
	rm ../Diff ../Patch
