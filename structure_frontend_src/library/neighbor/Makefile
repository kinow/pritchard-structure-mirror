# Makefile
#
# Generic Linux/Unix Makefile for PHYLIP 3.6.

PACKAGE=phylip
VERSION=3.68

# We use GNU's version of the make utility. It may be called "gmake" on
# your system.
#
# If you're using a RedHat Linux system with default locations for 
# gcc libraries, you probably don't need to change anything. You might
# might change the first noncomment statement below to redefine $(EXEDIR)
# if you'd like your executables installed in a different location than
# our default.
#
# Users with systems that differ substantially from ours may need to set
# the following variables: $(CC) $(CFLAGS) $(DFLAGS) $(LIBS) $(DLIBS)
#
# When uncompressed and extracted, the tar archive phylip-3.6x.tar.gz 
# produces the following directory structure:
#
#   phylip-3.6x/src -- the source code, including this Makefile
#   phylip-3.6x/exe -- executables, changed by changing $(EXEDIR) value
#   phylip-3.6x/doc -- html documentation
#
#  To use the PHYLIP v3.6 Makefile, type from the phylip-3.6x/src directory:
#
#      make install         to compile the whole package and install
#                           the executables in $(EXEDIR), and then
#                           remove the object files to save space
#
#      make all             to compile the whole package but not install it
#                           or remove the object files. 
#
#      make put             to move the executables into $(EXEDIR)
#
#      make clean           to remove all object files and executables from the
#                           current directory
#
#      make dnaml           to compile and link one program, (in this example,
#                           DnaML) and leave the executable and object files
#                           in the current directory (where the source code is).
#                           You will have to move the executable into the
#                           executables directory (e.g. "mv dnaml ../exe")
#                           Note that the program name should be lower case.
# 
# ----------------------------------------------------------------------------
#  (Starting here is the section where you may want to change things)
# ----------------------------------------------------------------------------
#
# the following specifies the directory where the executables will be placed
EXEDIR  = ../exe
#
# ----------------------------------------------------------------------------
#
# The following statements set these variables:
#
#    CC     -- the name (and, optionally, location) of your C compiler
#    CFLAGS -- compiler directives needed to compile most programs
#    DFLAGS -- compiler directives needed to compile draw programs
#    LIBS   -- non-default system libraries needed to compile most programs
#    DLIBS  -- non-default system libraries needed to compile draw programs
#
# We've provided a set of possible values for each variable.
#
# The value used is the one without a "#" at the beginning of the line.
#
# To try an alternate value, make sure the one you want has no "#"
# as its first character and that all other possibilities have "#" for
# their first character.
#
# Advanced users may need to further edit one of the alternatives in
# order to correctly compile on their system.
#
# ----------------------------------------------------------------------------
#
# The next two assignments are the invocations of the compiler
#
# This one specifies the "cc" C compiler
#CC        = cc
#
#  To use GCC instead:
CC        = gcc
#
# ----------------------------------------------------------------------------
#
# This is the CFLAGS statement. It specifies compiler behavior.
#
# Here are some possible CFLAGS statements:
#
#
#A minimal one
#CFLAGS =
#
# A basic one for debugging
#CFLAGS  = -g 
#
# An optimized one for gcc
CFLAGS  = -lm -O3 -fomit-frame-pointer
#CFLAGS  = -O3 -fomit-frame-pointer
#
# For some serious debugging using Gnu gcc
#
#CFLAGS=-g -Wall -Wmain -Wmissing-prototypes -Wreturn-type -Wstrict-prototypes  -Wunused -Werror -Wredundant-decls -Waggregate-return -Wcast-align -Wcomment
#
# For Digital Alpha systems with Compaq Tru64 Unix
# (however, be aware that this may cause floating-point problems in programs
#  like Dnaml owing to not using IEEE floating point standards).
#CFLAGS = -fast
#
# ----------------------------------------------------------------------------
#
# This is the DFLAGS statement. It specifies compiler behavior for the
# programs drawgram and drawtree. It adds additional information to
# the $(CFLAGS) value so these programs can use X11 graphics.
#
# A minimal one -- drawing programs will run, but will not use X11 graphics.
# If you use this one, you must also use the minimal value for $(DLIBS)
LDFLAGS  = $(CFLAGS) -DX
#
# for Linux with X Windows development packages installed
# or for MacOS X with X Windows installed.  You should also
# use the corresponding value for $(DLIBS). If the Xlib library
# for the X windowing system is somewhere unexpected, you may have 
# to change the path /usr/X11R6/lib in this one.
#DFLAGS = $(CFLAGS) -DX -I/usr/X11R6/include
#
# ----------------------------------------------------------------------------
#
# Most of the programs need only the math libraries, specified like this;
#
LIBS    = -lm
#
# The drawing programs also need access to the X windowing system. This is
# specified with the DLIBS variable.
#
# A minimal one -- drawing programs will run, but will not use X11 graphics.
# you must also set DFLAGS to the minimal value
LDLIBS  = $(LIBS)
#
# For Linux with X windows development packages installed
# or for MacOS X with X windows installed.  If the Xlib library
# for the X windowing system is somewhere unexpected, you may have
# to change the path /usr/X11R6/lib in this one. If you use this
# value for $(DLIBS), you should also use the corresponding value
# for $(DFLAGS)
#DLIBS= $(LIBS) -L/usr/X11R6/lib/ -lX11 -lXaw -lXt
#
# ----------------------------------------------------------------------------
#  (After this point there should not be any reason to change anything)
# ----------------------------------------------------------------------------
#
#
# the list of programs
# draw programs are listed last since they are the most likely to cause
# compilation or linking problems

PROGS   =		neighbor \

#PROGS   =		drawtree \
#				neighbor				

#
# general commands
#

#  The first target it executed if you just type "make".  It tells you how to
#  use the Makefile.
#
help:
	@echo ""
	@echo " To use the PHYLIP v3.6 Makefile, type"
	@echo "     make install       to compile the whole package and install"
	@echo "                          the executables in $(EXEDIR), and then"
	@echo "                          remove the object files to save space"
	@echo "     make all           to compile the whole package but not install it"
	@echo "                          or remove the object files"
	@echo "     make put           to move the executables into $(EXEDIR)"
	@echo "     make clean         to remove all object files and executables from the"
	@echo "                          current directory"
	@echo "     make dnaml         to compile and link one program, (in this example,"
	@echo "                          Dnaml) and leave the executable and object files"
	@echo "                          in the current directory (where the source code is)."
	@echo "                          You will have to move the executable into the"
	@echo "                          executables directory (e.g. \"mv dnaml $(EXEDIR)\")"
	@echo "                          Note that the program name should be lower case."
	@echo " "

introduce:
	@echo "Building PHYLIP version $(VERSION)"

all:        introduce $(PROGS)
	@echo "Finished compiling."
	@echo ""

install:        all put clean
	@echo "Done."
	@echo ""

put:
	@echo "Installing PHYLIP v3.6 binaries in $(EXEDIR)"
	@mkdir -p $(EXEDIR)
	@cp $(PROGS) $(EXEDIR)
	@echo "Installing font files in $(EXEDIR)"
	@cp font* $(EXEDIR)
	@echo "Finished installation."
	@echo ""

clean:
	@echo "Removing object files to save space"
	@rm -f *.o
	@echo "Finished removing object files.  Now will remove"
	@echo "executable files from the current directory, but not from the"
	@echo "executables directory.  (If some are not here, the makefile"
	@echo "will terminate with an error message but this is not a problem)"
	@echo ""
	@echo "Removing executables from this directory"
	@rm -f $(PROGS)
	@echo "Finished cleanup."
	@echo ""

#
# compile object files shared between programs
# (make's implicit rule for %.o will take care of these)
#

phylip.o:     phylip.h
#seq.o:        phylip.h seq.h
#disc.o:       phylip.h disc.h
#discrete.o:   phylip.h discrete.h
#dollo.o:      phylip.h dollo.h
#wagner.o:     phylip.h wagner.h
dist.o:       phylip.h dist.h
#cont.o:       phylip.h cont.h
#mlclock.o:    phylip.h mlclock.h
#moves.o:      phylip.h moves.h
#printree.o:   phylip.h printree.h

#
# compile the individual programs
#

#drawtree.o:     drawtree.c draw.h phylip.h
#	$(CC) $(DFLAGS) -c drawtree.c

#drawtree:     drawtree.o draw.o draw2.o phylip.o
#	$(CC) $(DFLAGS) draw.o draw2.o drawtree.o phylip.o $(DLIBS) -o drawtree


drawtree.o: drawtree.c draw.h phylip.h

drawtree: drawtree.o draw.o draw2.o phylip.o 

neighbor.o: neighbor.c dist.h phylip.h draw.c draw.h 

neighbor: neighbor.o dist.o phylip.o draw.o draw2.o
#neighbor: 
#	gcc -lm neighbor.o dist.o phylip.o dist.o phylip.o draw.o draw2.o



# ----------------------------------------------------------------------------
#  The following section is used to build a PHYLIP distribution. All sources
#  and other files except the documentation files must be placed in the
#  current directory.  The HTML documentation files must be in folder "doc"
#  within this, the Mac icons in folder "mac", and the Windows icons and
#  resource files must be in folder "icons"
#
#  Usage:
#  	make distdir	- Build the distribution dir phylip-<vers>/
#  	make dist	- Make a tarred and gzipped phylip-<vers>.tar.gz
# ----------------------------------------------------------------------------

DIST_COMMON = phylip.html 

#DOCS= doc/clique.html doc/consense.html doc/contchar.html doc/contml.html \
#      doc/contrast.html doc/discrete.html doc/distance.html doc/dnacomp.html \
#      doc/dnadist.html doc/dnainvar.html doc/dnaml.html doc/dnamlk.html \
#      doc/dnamove.html doc/dnapars.html doc/dnapenny.html doc/dollop.html \
#      doc/dolmove.html doc/dolpenny.html doc/drawgram.html doc/draw.html \
#      doc/drawtree.html doc/factor.html doc/fitch.html doc/gendist.html \
#      doc/kitsch.html doc/main.html doc/mix.html doc/move.html \
#      doc/neighbor.html doc/pars.html doc/penny.html doc/proml.html \
#      doc/promlk.html doc/protdist.html doc/protpars.html doc/restdist.html \
#      doc/restml.html doc/retree.html doc/seqboot.html doc/sequence.html \
#      doc/treedist.html doc/phylip.gif

#SOURCES= COPYRIGHT Makefile Makefile.bcc Makefile.cyg Makefile.msvc \
#	 Makefile.osx compalpha.com linkmac clique.c cons.c consense.c cons.h cont.c \
#	 cont.h contml.c contrast.c disc.c disc.h discrete.c discrete.h dist.c \
#	 dist.h dnacomp.c dnadist.c dnainvar.c dnaml.c dnamlk.c dnamove.c \
#	 dnapars.c dnapenny.c dollo.c dollo.h dollop.c dolmove.c dolpenny.c \
#	 draw2.c draw.c drawgram.c draw.h drawtree.c factor.c fitch.c gendist.c \
#	 interface.c interface.h io.h kitsch.c macface.c macface.h mix.c move.c \
#	 moves.c moves.h neighbor.c newmove.c pars.c penny.c \
#	 phylip.c phylip.h proml.c promlk.c protdist.c protpars.c restdist.c \
#	 restml.c retree.c seqboot.c seq.c seq.h treedist.c wagner.c wagner.h \
#	 mlclock.c mlclock.h printree.c printree.h

#MAC= \
#		Info.plist.in boot.icns clique.icns command.in consense.icns \
#	contml.icns contrast.icns disc.icns dist.icns dna.icns dnacomp.icns \
#	dnadist.icns dnainvar.icns dnaml.icns dnamlk.icns dnamove.icns \
#	dnapars.icns dnapenny.icns dollo.icns dollop.icns dolmove.icns \
#	dolpenny.icns drawgram.icns drawtree.icns factor.icns fitch.icns \
#	gendist.icns kitsch.icns mac.sit mix.icns move.icns neighbor.icns \
#	pars.icns penny.icns proml.icns promlk.icns protdist.icns protein.icns \
#	protpars.icns restdist.icns restml.icns restrict.icns retree.icns \
#	seqboot.icns treedist.icns

#ICONS= 		boot.ico clique.ico clique.rc clique.rcb consense.ico \
#		consense.rc consense.rcb contml.ico contml.rc contml.rcb \
#		contrast.ico contrast.rc contrast.rcb disc.ico dist.ico dna.ico \
#		dnacomp.rc dnacomp.rcb dnadist.rc dnadist.rcb dnainvar.rc \
#		dnainvar.rcb dnaml.rc dnaml.rcb dnamlk.rc dnamlk.rcb dnamove.rc \
#		dnamove.rcb dnapars.rc dnapars.rcb dnapenny.rc dnapenny.rcb \
#		dollo.ico dollop.rc dollop.rcb dolmove.rc dolmove.rcb \
#		dolpenny.rc dolpenny.rcb drawgram.ico drawgram.rc drawgram.rcb \
#		drawtree.ico drawtree.rc drawtree.rcb factor.rc factor.rcb \
#		fitch.rc fitch.rcb gendist.ico gendist.rc gendist.rcb kitsch.rc \
#		kitsch.rcb mix.rc mix.rcb move.rc move.rcb neighbor.rc \
#		neighbor.rcb pars.rc pars.rcb penny.rc penny.rcb proml.rc \
#		proml.rcb promlk.rc promlk.rcb protdist.rc protdist.rcb \
#		protein.ico protpars.rc protpars.rcb restdist.rc restdist.rcb \
#		restml.rc restml.rcb restrict.ico retree.ico retree.rc \
#		retree.rcb seqboot.rc seqboot.rcb treedist.ico treedist.rc \
#		treedist.rcb

FONTS= font1

DISTDIR=$(PACKAGE)-$(VERSION)
dist_SRCDIR=$(DISTDIR)/src
dist_DOCDIR=$(DISTDIR)/doc
dist_EXEDIR=$(DISTDIR)/exe
MACICONDIR=src/mac

SHELL=bash

# We use this target to create a tarred and gzipped distribution of PHYLIP
dist: distdir
	-chmod -R a+r $(DISTDIR)
	tar chozf $(DISTDIR).tar.gz $(DISTDIR)
	-rm -rf $(DISTDIR)

# This target creates the distribution directory
distdir: $(DIST_COMMON) $(DOCS) $(SOURCES)
	-rm -rf $(DISTDIR)
	mkdir $(DISTDIR) && \
	mkdir $(dist_EXEDIR) && \
	mkdir $(dist_DOCDIR) && \
	mkdir $(dist_SRCDIR)
	mkdir $(dist_SRCDIR)/mac
	mkdir $(dist_SRCDIR)/icons
	for i in $(DIST_COMMON) ; do \
	  cp -r $$i $(DISTDIR) ; \
	done
	for i in $(DOCS) ; do \
	  cp -r $$i $(dist_DOCDIR) ; \
	done
	for i in $(SOURCES) ; do \
	  cp -r $$i $(dist_SRCDIR) ; \
	done
	for i in $(MAC) ; do \
	  cp -r mac/$$i $(dist_SRCDIR)/mac ; \
	done
	for i in $(ICONS) ; do \
	  cp -r icons/$$i $(dist_SRCDIR)/icons ; \
	done
	for i in $(FONTS) ; do \
	  cp -r $$i $(dist_SRCDIR) ; \
	done

# This target untars the dist and checks that it can be compiled and remade
distcheck: dist
	-rm -rf $(DISTDIR)
	tar xzf $(DISTDIR).tar.gz
	cd $(DISTDIR)/$(SRCDIR) \
	  && make all
	-rm -rf $(DISTDIR)
	@echo "$(DISTDIR).tar.gz is ready for distribution"

# Makefile
