JAVA_COMPILER = javac
JAVA_RUN = java
BIN_DIR = bin
SRC_DIR = test
all: 
	$(JAVA_COMPILER) -d $(BIN_DIR) $(SRC_DIR)/*.java
run: all
	$(JAVA_RUN) -cp $(BIN_DIR) Admin
clean:
	rm -rf $(BIN_DIR)
