IDIR=include
CC=clang  #could be gcc|clang
CFLAGS=-I${IDIR}
ODIR=lib

LIBS=-lm
_DEPS=hellomake.h
DEPS=$(patsubst %,$(IDIR)/%,$(_DEPS))

_OBJ = hellomake.o hellofunc.o
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))


$(ODIR)/%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)


hellomake: $(OBJ)
	gcc -o $@ $^ $(CFLAGS) $(LIBS)


.PHONY: clean
clean: 
	rm -f $(ODIR)/*.o hellomake
