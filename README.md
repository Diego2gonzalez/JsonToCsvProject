# JsonToCsvProject

---

## 1️⃣ Project Overview
**JsonToCsvProject** is a Java desktop application designed to **read JSON files** and **convert them into CSV files**.

- Uses **Gson** for JSON parsing.
- Uses **OpenCSV** for CSV writing.

This ensures a reliable and structured transformation process.

---

## 2️⃣ Requirements and Compatibility

- **Java Version:** 17
- **Build Tool:** Maven
- **Dependencies:**
    - Gson (`com.google.gson`)
    - OpenCSV (`com.opencsv.CSVWriter`)
    - JUnit 5 (`org.junit.jupiter`)

> **Note:** If not using Maven, manually add the JARs:
> - `gson-<version>.jar`
> - `opencsv-<version>.jar`
> - `junit-jupiter-<version>.jar`

---

## 3️⃣ Repository Structure

| Folder | Description |
|--------|-------------|
| `src/main/java/JsonReader/` | Main Java code:<br>- `JsonReader.java`<br>- `CsvWriter.java`<br>- `Main.java` |
| `src/test/java/JsonReader/` | JUnit tests:<br>- `EmptyTest.java`<br>- `InvalidTest.java` |
| `src/test/resources/` | Sample JSON files:<br>- `empty.json`<br>- `invalid.json`<br>- `user.json` |

---

## 4️⃣ Project Configuration

- Input/output file paths are entered via console when running `Main.java`.
- Example:
```text
Enter JSON file path: src/test/resources/user.json
Enter CSV file path to save: src/test/resources/user.csv


Paths can be replaced to test different JSON files.

5️⃣ JSON → CSV Conversion
Step 1: Reading JSON

Single object → converted into a Map<String,Object>

Array of objects → each element converted into a Map<String,Object> and stored in a List<Map<String,Object>>

Algorithm:

if JSON is object:
    create Map and add to List
else if JSON is array:
    for each element:
        convert element to Map
        add Map to List

Step 2: Writing CSV

Retrieve headers from the first Map → CSV headers

For each Map in the list:

Iterate over headers

Convert values to strings

If null → write empty string ""

Write headers and rows using OpenCSV

Algorithm:

headers = keys from first Map
write headers to CSV

for each Map in List:
    row = []
    for each header:
        value = Map.get(header)
        if value is null: value = ""
        row.add(value)
    write row to CSV


Flow Diagram (Textual)

JSON File
   │
   ▼
Read JSON with Gson
   │
   ▼
Convert to Map/List
   │
   ▼
Write CSV with OpenCSV
   │
   ▼
CSV File

6️⃣ Sample Input / Output

Input JSON (user.json):

[
  {"name": "Alice", "age": 28, "city": "Paris"},
  {"name": "Bob", "age": 32, "city": "Berlin"},
  {"name": "Charlie", "age": null, "city": "London"}
]


Generated CSV (user.csv):

name,age,city
Alice,28,Paris
Bob,32,Berlin
Charlie,,London

7️⃣ Error Handling

Program handles:

Invalid JSON → prints error and exits gracefully

Empty JSON file → returns empty list and prints warning

File not found → displays file path error

Ensures robustness and reliable execution.

8️⃣ JUnit Testing

EmptyTest.java → validates empty JSON handling

InvalidTest.java → validates invalid JSON handling

Tests cover:

JSON reading (objects & arrays)

CSV writing with correct headers & rows

Data consistency & error handling

Run tests using Maven:

mvn test

9️⃣ JavaDoc Documentation

All classes and methods include JavaDoc:

Purpose of class/method

Parameters & return values

Example usage (if applicable)

Supports maintainability and professional documentation.

10️⃣ Improvements from Previous Sprint

Full JSON → CSV transformation implemented

Validated program with sample JSON (including empty & invalid files)

Added JUnit tests for automated verification

11️⃣ References

- [Gson Documentation](https://github.com/google/gson)  
- [OpenCSV Documentation](http://opencsv.sourceforge.net/)  
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)

12️⃣ Notes

Input/output paths via console prompt

Handles arrays of objects & null values

Project separates production code and test resources for clarity