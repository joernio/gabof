## gabof

generate a buch of files

## compile with

```
gradle jar
```

## example usage

```
java -jar ./build/libs/gabof-1.0-SNAPSHOT.jar /path/to/input/dir --number-of-files 10000
```

OR

```
$ ./gabof.sh /tmp/empty --number-of-files 100
Created subdirectory at `/tmp/empty/gabof`.
Wrote 10/100 to `/tmp/empty`.
Wrote 20/100 to `/tmp/empty`.
Wrote 30/100 to `/tmp/empty`.
Wrote 40/100 to `/tmp/empty`.
Wrote 50/100 to `/tmp/empty`.
Wrote 60/100 to `/tmp/empty`.
Wrote 70/100 to `/tmp/empty`.
Wrote 80/100 to `/tmp/empty`.
Wrote 90/100 to `/tmp/empty`.
Wrote 100/100 to `/tmp/empty`.
Done.

//$ ls /tmp/empty/gabof/*.kt | wc -l
//100
```

## options

```
$ ./gabof.sh --help
Usage: app [OPTIONS] OUTDIR

Options:
  --number-of-files INT            Number of files
  --number-of-fns-per-file INT     Number of functions per file
  --number-of-printlns-per-fn INT  Number of println expressions per function
  -h, --help                       Show this message and exit
```

