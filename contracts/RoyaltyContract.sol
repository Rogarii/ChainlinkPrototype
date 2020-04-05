pragma solidity ^0.5.17;

contract RoyaltyContract{
  
    //represents the total number of tokens for both types of royalties to be split between the royalty holders
    uint256 private constant totalRoyaltyValue = 100000;
    
    //determines if contract is currently active or is being setup still
    bool private active = false;
    
    //hold the timestamp for when the contract goes active
    uint256 private activeTime;
  
    //Array to hold the numerous royalty holders of the contract
    mapping(address => holder) private royaltyHolders;
    
    //array of all addresses in the royaltyHolders mapping
    address[] private holderAddresses;
    
    //total number of royaltyHolders
    uint256 private totalHolders = 0;
    
    //musical property title associated with contract
    string private propertyTitle;
    
    //musical property artist associated with contract
    string private propertyArtist;
    
    //id of property in local sql db
    uint256 private propertyId;
  
    //Object to Represent the Royalty Holders of the contract  
    struct holder {
        string firstName;
        string lastName;
        uint256 dateAdded;
        uint256 mechRoy;
        uint256 prefRoy;
        uint256 holderId;
        bool approved;
        uint256 timeApproved;
        bool authorized;
    }
    
    //Constructor statement - adds initial user to contract
    constructor(string memory firstName, string memory lastName, uint256 dateAdded, uint256 mechRoy, uint256 prefRoy,
                uint256 id, string memory propTitle, string memory propArtist, uint256 propId) public {
        holder memory newHolder = holder(firstName, lastName, dateAdded, mechRoy, prefRoy, id, false, dateAdded, true);
        royaltyHolders[msg.sender] = newHolder;
        holderAddresses.push(msg.sender);
        totalHolders++;
        propertyTitle = propTitle;
        propertyArtist = propArtist;
        propertyId = propId;
    }
    
    //adds new holder to contract if the address sending message is authorized
    function addHolder(uint256 dateAdded, uint256 mechRoy, uint256 prefRoy, address newHolderAddress, uint256 id) public {
        require(royaltyHolders[msg.sender].authorized, "Unauthorized User");
        require(!active, "Contract Already active");
        holder memory newHolder = holder("", "", dateAdded, mechRoy, prefRoy, id, false, 0, true);
        royaltyHolders[newHolderAddress] = newHolder;
        holderAddresses.push(newHolderAddress);
        totalHolders++;
        //function to unapprove all currently approved holders
        unApproveAll();
    }
    
    //approves the contract for the user sending request
    function approveContract(uint256 currentDate, string memory firstName, string memory lastName) public {
        require(royaltyHolders[msg.sender].authorized, "Unauthorized User");
        require(!royaltyHolders[msg.sender].approved, "Contract Already Approved");
        royaltyHolders[msg.sender].approved = true;
        royaltyHolders[msg.sender].timeApproved = currentDate;
        royaltyHolders[msg.sender].firstName = firstName;
        royaltyHolders[msg.sender].lastName = lastName;
    }
    
    //function to check approval status
    function checkApprovals() public view returns (bool){
        for(uint i = 0; i < totalHolders; i++){
            if(!royaltyHolders[holderAddresses[i]].approved){
                return false;
            }
        }
        return true;
    }
    
    //function to unapprove all users on a contract change
    function unApproveAll() private {
        for(uint i = 0; i < totalHolders; i++){
            royaltyHolders[holderAddresses[i]].approved = false;
            royaltyHolders[holderAddresses[i]].timeApproved = 0;
        }
    }
    
    //checks for all approvals and activates the contract, logs time for reference
    function activateContract(uint256 currentDate) public {
        require(holderAddresses[0] == msg.sender, "Not Contract initiator");
        require(!active, "Contract Already active");
        if(checkApprovals()){
            active = true;
            activeTime = currentDate;
        }
    }
    
    //returns total number of roaylty holders for the contract
    function getTotalHolders() public view returns (uint256){
        return totalHolders;
    }
    
    //returns timestamp of when the contract was activated
    function getActiveTime() public view returns (uint256){
        return activeTime;
    }
    
    //returns holder information based off of address
    function getRoyaltyHolder(address queryHolderAddress) public view returns (string memory, string memory, uint256, uint256, uint256){
        holder memory queryHolder = royaltyHolders[queryHolderAddress];
        return(queryHolder.firstName, queryHolder.lastName, queryHolder.dateAdded, queryHolder.mechRoy/totalRoyaltyValue, queryHolder.prefRoy/totalRoyaltyValue);
    }
    
    //returns array of all royaly holders address'
    function getAllRoyaltyHolders() public view returns(address[] memory){
        return holderAddresses;
    }
    
    //returns property title and artist for associated musical property
    function getPropertyInfo() public view returns (string memory, string memory){
        return (propertyTitle, propertyArtist);
    }
    
    //returns sql db id for property
    function getPropertyId() public view returns (uint256){
        return propertyId;
    }
}