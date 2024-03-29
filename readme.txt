SpringBoot application that generates uuid and finds palindromes in strings.

queries to API are
/generate
/palindrome
/uuid

application starts by defaul on port 8080
example requests are therefore:
http://localhost:8080/generate
http://localhost:8080/palindrome
http://localhost:8080/uuid

palindrome request takes param 'string', the string to find longest palindrome substring in
generate and uuid requests take params int x, y, z which determine the values modifying generated number and number of iterations of number generations in a sequence.
generate returns just a uuid
uuid return uuid and the longest palindrome in that uuid

my interpretation of the requirements was:
1. generate a random base number, add it to sequence
2. if even, modify base with x, add that to sequence
3. else if odd, modify base with y, add that to sequence
4. longest palindrome does not apply to generation, only complete uuids
5. ensure that 2 and 3 add z values to sequence in every uuid (i.e. modify and add numbers in a loop z times)
6. more than half of uuid should be generated by rules 2 and 3

tests were added to the src/test directory and use junit

example requests:
http://localhost:8080/generate?x=2&y=7&z=5
http://localhost:8080/palindrome?string='amanaplanacanalpanama'
http://localhost:8080/uuid?x=5&y=7&z=11
