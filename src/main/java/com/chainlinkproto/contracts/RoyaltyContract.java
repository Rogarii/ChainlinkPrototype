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
import org.web3j.tuples.generated.Tuple2;
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
    public static final String BINARY = "608060405260008060006101000a81548160ff02191690831515021790555060006004553480156200003057600080fd5b5060405162001c3338038062001c3383398181016040526101208110156200005757600080fd5b81019080805160405193929190846401000000008211156200007857600080fd5b838201915060208201858111156200008f57600080fd5b8251866001820283011164010000000082111715620000ad57600080fd5b8083526020830192505050908051906020019080838360005b83811015620000e3578082015181840152602081019050620000c6565b50505050905090810190601f168015620001115780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200013557600080fd5b838201915060208201858111156200014c57600080fd5b82518660018202830111640100000000821117156200016a57600080fd5b8083526020830192505050908051906020019080838360005b83811015620001a057808201518184015260208101905062000183565b50505050905090810190601f168015620001ce5780820380516001836020036101000a031916815260200191505b5060405260200180519060200190929190805190602001909291908051906020019092919080519060200190929190805160405193929190846401000000008211156200021a57600080fd5b838201915060208201858111156200023157600080fd5b82518660018202830111640100000000821117156200024f57600080fd5b8083526020830192505050908051906020019080838360005b838110156200028557808201518184015260208101905062000268565b50505050905090810190601f168015620002b35780820380516001836020036101000a031916815260200191505b5060405260200180516040519392919084640100000000821115620002d757600080fd5b83820191506020820185811115620002ee57600080fd5b82518660018202830111640100000000821117156200030c57600080fd5b8083526020830192505050908051906020019080838360005b838110156200034257808201518184015260208101905062000325565b50505050905090810190601f168015620003705780820380516001836020036101000a031916815260200191505b50604052602001805190602001909291905050506200038e6200058b565b6040518061012001604052808b81526020018a815260200189815260200188815260200187815260200186815260200160001515815260200189815260200160011515815250905080600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082015181600001908051906020019062000434929190620005db565b50602082015181600101908051906020019062000453929190620005db565b5060408201518160020155606082015181600301556080820151816004015560a0820151816005015560c08201518160060160006101000a81548160ff02191690831515021790555060e082015181600701556101008201518160080160006101000a81548160ff02191690831515021790555090505060033390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505060046000815480929190600101919050555083600590805190602001906200055a92919062000662565b5082600690805190602001906200057392919062000662565b50816007819055505050505050505050505062000711565b604051806101200160405280606081526020016060815260200160008152602001600081526020016000815260200160008152602001600015158152602001600081526020016000151581525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200061e57805160ff19168380011785556200064f565b828001600101855582156200064f579182015b828111156200064e57825182559160200191906001019062000631565b5b5090506200065e9190620006e9565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620006a557805160ff1916838001178555620006d6565b82800160010185558215620006d6579182015b82811115620006d5578251825591602001919060010190620006b8565b5b509050620006e59190620006e9565b5090565b6200070e91905b808211156200070a576000816000905550600101620006f0565b5090565b90565b61151280620007216000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80635de5f3be116100665780635de5f3be1461019b57806368d8ed491461028a5780639335ee42146103c8578063bc69764014610427578063df03ba68146105835761009e565b806329107708146100a35780632b3c0db3146100c557806333d9eeba146100e357806335c2bd63146101015780634f1fe11d1461012f575b600080fd5b6100ab6105a1565b604051808215151515815260200191505060405180910390f35b6100cd61065e565b6040518082815260200191505060405180910390f35b6100eb610668565b6040518082815260200191505060405180910390f35b61012d6004803603602081101561011757600080fd5b8101908080359060200190929190505050610672565b005b610199600480360360a081101561014557600080fd5b81019080803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506107ff565b005b6101a3610b2a565b604051808060200180602001838103835285818151815260200191508051906020019080838360005b838110156101e75780820151818401526020810190506101cc565b50505050905090810190601f1680156102145780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b8381101561024d578082015181840152602081019050610232565b50505050905090810190601f16801561027a5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b6102cc600480360360208110156102a057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c71565b604051808060200180602001868152602001858152602001848152602001838103835288818151815260200191508051906020019080838360005b83811015610322578082015181840152602081019050610307565b50505050905090810190601f16801561034f5780820380516001836020036101000a031916815260200191505b50838103825287818151815260200191508051906020019080838360005b8381101561038857808201518184015260208101905061036d565b50505050905090810190601f1680156103b55780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b6103d0610ec5565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104135780820151818401526020810190506103f8565b505050509050019250505060405180910390f35b6105816004803603606081101561043d57600080fd5b81019080803590602001909291908035906020019064010000000081111561046457600080fd5b82018360208201111561047657600080fd5b8035906020019184600183028401116401000000008311171561049857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156104fb57600080fd5b82018360208201111561050d57600080fd5b8035906020019184600183028401116401000000008311171561052f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610f53565b005b61058b61122d565b6040518082815260200191505060405180910390f35b600080600090505b6004548110156106555760026000600383815481106105c457fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060060160009054906101000a900460ff1661064857600091505061065b565b80806001019150506105a9565b50600190505b90565b6000600454905090565b6000600754905090565b3373ffffffffffffffffffffffffffffffffffffffff16600360008154811061069757fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461074b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260168152602001807f4e6f7420436f6e747261637420696e69746961746f720000000000000000000081525060200191505060405180910390fd5b6000809054906101000a900460ff16156107cd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f436f6e747261637420416c72656164792061637469766500000000000000000081525060200191505060405180910390fd5b6107d56105a1565b156107fc5760016000806101000a81548160ff021916908315150217905550806001819055505b50565b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060080160009054906101000a900460ff166108c1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f556e617574686f72697a6564205573657200000000000000000000000000000081525060200191505060405180910390fd5b6000809054906101000a900460ff1615610943576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f436f6e747261637420416c72656164792061637469766500000000000000000081525060200191505060405180910390fd5b61094b611368565b6040518061012001604052806040518060200160405280600081525081526020016040518060200160405280600081525081526020018781526020018681526020018581526020018381526020016000151581526020016000815260200160011515815250905080600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000820151816000019080519060200190610a0e9291906113b8565b506020820151816001019080519060200190610a2b9291906113b8565b5060408201518160020155606082015181600301556080820151816004015560a0820151816005015560c08201518160060160006101000a81548160ff02191690831515021790555060e082015181600701556101008201518160080160006101000a81548160ff02191690831515021790555090505060038390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600460008154809291906001019190505550610b22611237565b505050505050565b60608060056006818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bc65780601f10610b9b57610100808354040283529160200191610bc6565b820191906000526020600020905b815481529060010190602001808311610ba957829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c625780601f10610c3757610100808354040283529160200191610c62565b820191906000526020600020905b815481529060010190602001808311610c4557829003601f168201915b50505050509050915091509091565b6060806000806000610c81611368565b600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060405180610120016040529081600082018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d655780601f10610d3a57610100808354040283529160200191610d65565b820191906000526020600020905b815481529060010190602001808311610d4857829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e075780601f10610ddc57610100808354040283529160200191610e07565b820191906000526020600020905b815481529060010190602001808311610dea57829003601f168201915b50505050508152602001600282015481526020016003820154815260200160048201548152602001600582015481526020016006820160009054906101000a900460ff16151515158152602001600782015481526020016008820160009054906101000a900460ff1615151515815250509050806000015181602001518260400151620186a0846060015181610e9957fe5b04620186a0856080015181610eaa57fe5b04849450839350955095509550955095505091939590929450565b60606003805480602002602001604051908101604052809291908181526020018280548015610f4957602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610eff575b5050505050905090565b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060080160009054906101000a900460ff16611015576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f556e617574686f72697a6564205573657200000000000000000000000000000081525060200191505060405180910390fd5b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060060160009054906101000a900460ff16156110d8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f436f6e747261637420416c726561647920417070726f7665640000000000000081525060200191505060405180910390fd5b6001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060060160006101000a81548160ff02191690831515021790555082600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206007018190555081600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000190805190602001906111d0929190611438565b5080600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001019080519060200190611227929190611438565b50505050565b6000600154905090565b60008090505b600454811015611365576000600260006003848154811061125a57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060060160006101000a81548160ff021916908315150217905550600060026000600384815481106112ec57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060070181905550808060010191505061123d565b50565b604051806101200160405280606081526020016060815260200160008152602001600081526020016000815260200160008152602001600015158152602001600081526020016000151581525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106113f957805160ff1916838001178555611427565b82800160010185558215611427579182015b8281111561142657825182559160200191906001019061140b565b5b50905061143491906114b8565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061147957805160ff19168380011785556114a7565b828001600101855582156114a7579182015b828111156114a657825182559160200191906001019061148b565b5b5090506114b491906114b8565b5090565b6114da91905b808211156114d65760008160009055506001016114be565b5090565b9056fea265627a7a72315820e89b511f17c21e68330c3f1eccc25d0ac157c6f9dd3b50365a15609563154f8764736f6c63430005110032";

    public static final String FUNC_ACTIVATECONTRACT = "activateContract";

    public static final String FUNC_ADDHOLDER = "addHolder";

    public static final String FUNC_APPROVECONTRACT = "approveContract";

    public static final String FUNC_CHECKAPPROVALS = "checkApprovals";

    public static final String FUNC_GETACTIVETIME = "getActiveTime";

    public static final String FUNC_GETALLROYALTYHOLDERS = "getAllRoyaltyHolders";

    public static final String FUNC_GETPROPERTYID = "getPropertyId";

    public static final String FUNC_GETPROPERTYINFO = "getPropertyInfo";

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

    public RemoteFunctionCall<BigInteger> getPropertyId() {
        final Function function = new Function(FUNC_GETPROPERTYID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple2<String, String>> getPropertyInfo() {
        final Function function = new Function(FUNC_GETPROPERTYINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
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

    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id, String propTitle, String propArtist, BigInteger propId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(propTitle), 
                new org.web3j.abi.datatypes.Utf8String(propArtist), 
                new org.web3j.abi.datatypes.generated.Uint256(propId)));
        return deployRemoteCall(RoyaltyContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id, String propTitle, String propArtist, BigInteger propId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(propTitle), 
                new org.web3j.abi.datatypes.Utf8String(propArtist), 
                new org.web3j.abi.datatypes.generated.Uint256(propId)));
        return deployRemoteCall(RoyaltyContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id, String propTitle, String propArtist, BigInteger propId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(propTitle), 
                new org.web3j.abi.datatypes.Utf8String(propArtist), 
                new org.web3j.abi.datatypes.generated.Uint256(propId)));
        return deployRemoteCall(RoyaltyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RoyaltyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String firstName, String lastName, BigInteger dateAdded, BigInteger mechRoy, BigInteger prefRoy, BigInteger id, String propTitle, String propArtist, BigInteger propId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(dateAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(mechRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(prefRoy), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(propTitle), 
                new org.web3j.abi.datatypes.Utf8String(propArtist), 
                new org.web3j.abi.datatypes.generated.Uint256(propId)));
        return deployRemoteCall(RoyaltyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
