package com.chainlinkproto.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class RoyaltyContract extends Contract {
    public static final String BINARY = "[\r\n"
            + "\t{\r\n"
            + "\t\t\"inputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"firstName\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"lastName\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"dateAdded\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"mechRoy\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"prefRoy\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"id\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"nonpayable\",\r\n"
            + "\t\t\"type\": \"constructor\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": false,\r\n"
            + "\t\t\"inputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"currentDate\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"name\": \"activateContract\",\r\n"
            + "\t\t\"outputs\": [],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"nonpayable\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": false,\r\n"
            + "\t\t\"inputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"dateAdded\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"mechRoy\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"prefRoy\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"address\",\r\n"
            + "\t\t\t\t\"name\": \"newHolderAddress\",\r\n"
            + "\t\t\t\t\"type\": \"address\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"id\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"name\": \"addHolder\",\r\n"
            + "\t\t\"outputs\": [],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"nonpayable\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": false,\r\n"
            + "\t\t\"inputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"currentDate\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"firstName\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"lastName\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"name\": \"approveContract\",\r\n"
            + "\t\t\"outputs\": [],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"nonpayable\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": true,\r\n"
            + "\t\t\"inputs\": [],\r\n"
            + "\t\t\"name\": \"checkApprovals\",\r\n"
            + "\t\t\"outputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"bool\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"bool\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"view\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": true,\r\n"
            + "\t\t\"inputs\": [],\r\n"
            + "\t\t\"name\": \"getActiveTime\",\r\n"
            + "\t\t\"outputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"view\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": true,\r\n"
            + "\t\t\"inputs\": [],\r\n"
            + "\t\t\"name\": \"getAllRoyaltyHolders\",\r\n"
            + "\t\t\"outputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"address[]\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"address[]\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"view\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": true,\r\n"
            + "\t\t\"inputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"address\",\r\n"
            + "\t\t\t\t\"name\": \"queryHolderAddress\",\r\n"
            + "\t\t\t\t\"type\": \"address\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"name\": \"getRoyaltyHolder\",\r\n"
            + "\t\t\"outputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"string\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"string\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t},\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"view\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t},\r\n"
            + "\t{\r\n"
            + "\t\t\"constant\": true,\r\n"
            + "\t\t\"inputs\": [],\r\n"
            + "\t\t\"name\": \"getTotalHolders\",\r\n"
            + "\t\t\"outputs\": [\r\n"
            + "\t\t\t{\r\n"
            + "\t\t\t\t\"internalType\": \"uint256\",\r\n"
            + "\t\t\t\t\"name\": \"\",\r\n"
            + "\t\t\t\t\"type\": \"uint256\"\r\n"
            + "\t\t\t}\r\n"
            + "\t\t],\r\n"
            + "\t\t\"payable\": false,\r\n"
            + "\t\t\"stateMutability\": \"view\",\r\n"
            + "\t\t\"type\": \"function\"\r\n"
            + "\t}\r\n"
            + "]";

    public static final String FUNC_ACTIVATECONTRACT = "activateContract";

    public static final String FUNC_ADDHOLDER = "addHolder";

    public static final String FUNC_APPROVECONTRACT = "approveContract";

    public static final String FUNC_CHECKAPPROVALS = "checkApprovals";

    public static final String FUNC_GETACTIVETIME = "getActiveTime";

    public static final String FUNC_GETALLROYALTYHOLDERS = "getAllRoyaltyHolders";

    public static final String FUNC_GETROYALTYHOLDER = "getRoyaltyHolder";

    public static final String FUNC_GETTOTALHOLDERS = "getTotalHolders";

    @Deprecated
    protected RoyaltyContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RoyaltyContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RoyaltyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RoyaltyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> activateContract(BigInteger currentDate) {
        final Function function = new Function(
                FUNC_ACTIVATECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(currentDate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addHolder(BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, String newHolderAddress, BigInteger id) {
        final Function function = new Function(
                FUNC_ADDHOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.Address(160, newHolderAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveContract(BigInteger currentDate, String firstName, String lastName) {
        final Function function = new Function(
                FUNC_APPROVECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(currentDate), 
                new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> checkApprovals() {
        final Function function = new Function(FUNC_CHECKAPPROVALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> getActiveTime() {
        final Function function = new Function(FUNC_GETACTIVETIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getAllRoyaltyHolders() {
        final Function function = new Function(FUNC_GETALLROYALTYHOLDERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>> getRoyaltyHolder(String queryHolderAddress) {
        final Function function = new Function(FUNC_GETROYALTYHOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, queryHolderAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getTotalHolders() {
        final Function function = new Function(FUNC_GETTOTALHOLDERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static RoyaltyContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RoyaltyContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RoyaltyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RoyaltyContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RoyaltyContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RoyaltyContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RoyaltyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RoyaltyContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id)));
        return deployRemoteCall(RoyaltyContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id)));
        return deployRemoteCall(RoyaltyContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id)));
        return deployRemoteCall(RoyaltyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id)));
        return deployRemoteCall(RoyaltyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
