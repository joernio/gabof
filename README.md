## gabof

generate a buch of files

! this is experimental code. no guarantees

## generate executable jar

```
./gradlew jar
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

### example results


```
✿ mkdir -p /tmp/nothing && ./gabof.sh /tmp/nothing --number-of-files 1 --number-of-fns-per-file 1 --number-of-printlns-per-fn 6 && ls /tmp/nothing/gabof/* && cat /tmp/nothing/gabof/*
Found subdirectory named `gabof` at `/tmp/nothing`, removing it...
Created subdirectory at `/tmp/nothing/gabof`.
/tmp/nothing/gabof/file1.kt
package gabof

import kotlin.Int

public fun fn1_1(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  println(41414141)
  println(41414141)
  println(41414141)
  return 1
}
```


```
✿ mkdir -p /tmp/nothing && ./gabof.sh /tmp/nothing --number-of-files 3 --number-of-fns-per-file 2 --number-of-printlns-per-fn 3 && ls /tmp/nothing/gabof/* && cat /tmp/nothing/gabof/* 
Found subdirectory named `gabof` at `/tmp/nothing`, removing it...
Created subdirectory at `/tmp/nothing/gabof`.
/tmp/nothing/gabof/file1.kt  /tmp/nothing/gabof/file2.kt  /tmp/nothing/gabof/file3.kt
package gabof

import kotlin.Int

public fun fn1_1(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 1
}

public fun fn1_2(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 1
}
package gabof

import kotlin.Int

public fun fn2_1(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 2
}

public fun fn2_2(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 2
}
package gabof

import kotlin.Int

public fun fn3_1(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 3
}

public fun fn3_2(): Int {
  println(41414141)
  println(41414141)
  println(41414141)
  return 3
}

```


